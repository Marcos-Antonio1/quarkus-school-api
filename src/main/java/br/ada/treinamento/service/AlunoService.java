package br.ada.treinamento.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.NotFoundException;

import br.ada.treinamento.dto.AlunoRequest;
import br.ada.treinamento.dto.AlunoResponse;
import br.ada.treinamento.dto.ProfessorResponse;
import br.ada.treinamento.entity.Aluno;
import br.ada.treinamento.entity.Professor;
import br.ada.treinamento.repository.AlunoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class AlunoService {

    private AlunoRepository repository;
    private ProfessorService professorService;

    @Inject
    public AlunoService(AlunoRepository repository, ProfessorService professorService){
        this.repository = repository;
        this.professorService = professorService;
    }
    
    public List<AlunoResponse> retrieveAll(){
        log.info("listando alunos");

        List<Aluno> alunosEntitie = repository.listAll();
        
        return alunosEntitie.stream().map(aluno -> 
            AlunoResponse.builder().id(aluno.getId())
            .nome(aluno.getNome())
            .matricula(aluno.getMatricula())
            .sexo(aluno.getSexo()).build()
        ).collect(Collectors.toList());

    }

    public AlunoResponse getById(int id){
        log.info("listando o Aluno {}", id);

        Optional<Aluno> alunoBuscado = repository.findByIdOptional(id);

        if(!alunoBuscado.isPresent()){
            throw new NotFoundException();
        }

        Aluno aluno = alunoBuscado.get();

        if(Objects.isNull(aluno.getTutor())){
            return AlunoResponse.builder().id(aluno.getId())
            .matricula(aluno.getMatricula())
            .nome(aluno.getNome())
            .sexo(aluno.getSexo()).build();
        }

        ProfessorResponse professorResponse = ProfessorResponse.builder()
        .id(aluno.getTutor().getId()).nome(aluno.getTutor().getNome())
        .titulo(aluno.getTutor().getTitulo()).sexo(aluno.getTutor().getSexo()).build();

        return AlunoResponse.builder().id(aluno.getId())
        .matricula(aluno.getMatricula())
        .nome(aluno.getNome())
        .tutor(professorResponse)
        .sexo(aluno.getSexo()).build();

        
        
    }


    @Transactional
    public void save(@Valid AlunoRequest alunoRequest){
        log.info("Cadastrando Aluno {} ", alunoRequest);

        Aluno aluno = Aluno.builder()
            .nome(alunoRequest.getNome())
            .matricula(alunoRequest.getMatricula())
            .sexo(alunoRequest.getSexo())
            .build();

        repository.persist(aluno);
    }

    @Transactional
    public void alterar(int id,@Valid AlunoRequest alunoRequest){

        log.info("atualizando o Aluno de id {}", id);
        
        Optional<Aluno> alunoBuscado = repository.findByIdOptional(id);

        if(!alunoBuscado.isPresent()){
            throw new NotFoundException();
        }

        Aluno aluno = alunoBuscado.get();
        aluno.setNome(alunoRequest.getNome());
        repository.persist(aluno);
    }

    @Transactional
    public void deletar(int id){
        log.info("deletando o Aluno de id {}", id);
        repository.deleteById(id);
    }

    @Transactional
    public void cadastrarTutorParaAluno(int idAluno,int idTutor){
        Optional<Aluno> alunoBuscado = repository.findByIdOptional(idAluno);

        if(!alunoBuscado.isPresent()){
            throw new NotFoundException();
        }

        Aluno aluno = alunoBuscado.get();
        Professor professor = professorService.buscaProfessorPorId(idTutor);

        aluno.setTutor(professor);
        repository.persist(aluno);
    }
    
}
