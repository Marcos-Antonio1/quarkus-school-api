package br.ada.treinamento.service;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.NotFoundException;

import br.ada.treinamento.Mapper.ProfessorMapper;
import br.ada.treinamento.Mapper.AlunoMapper;
import br.ada.treinamento.Mapper.DisciplinaMapper;
import br.ada.treinamento.dto.AlunoResponse;
import br.ada.treinamento.dto.DisciplinaResponse;
import br.ada.treinamento.dto.ProfessorRequest;
import br.ada.treinamento.dto.ProfessorResponse;
import br.ada.treinamento.entity.Aluno;
import br.ada.treinamento.entity.Disciplina;
import br.ada.treinamento.entity.Professor;
import br.ada.treinamento.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ApplicationScoped
public class ProfessorService {

    private ProfessorRepository repository;
    private ProfessorMapper mapper;
    private DisciplinaMapper disciplinaMapper;
    private AlunoMapper alunoMapper;
    
    @Inject
    public ProfessorService(ProfessorRepository repository,
    ProfessorMapper professorMapper,
    DisciplinaMapper disciplinaMapper,
    AlunoMapper alunoMapper
    ){
        this.repository = repository;
        this.mapper = professorMapper;
        this.disciplinaMapper = disciplinaMapper;
        this.alunoMapper = alunoMapper;
    }
    
    public List<ProfessorResponse> retrieveAll(){

        log.info("listando professores");
        List<Professor> professorEntitie = repository.listAll();

        return mapper.toResponse(professorEntitie);
        
    }

    public ProfessorResponse getById(int id){
        
        log.info("listando o professor {}", id);
        Professor professor = buscaProfessorPorId(id);

        return mapper.toResponse(professor);
        

    }

    @Transactional
    public void save(@Valid ProfessorRequest professorRequest){
        
        log.info("Cadastrando professor {} ", professorRequest);
        Professor professor = mapper.toEntity(professorRequest);

        repository.persist(professor);

    }

    @Transactional
    public void alterar(int id,@Valid ProfessorRequest professorRequest){
        
        log.info("atualizando o professor de id {}", id);
        Professor professor = buscaProfessorPorId(id);

        professor.setNome(professorRequest.getNome());
        professor.setTitulo(professorRequest.getTitulo());

        repository.persist(professor);
    }

    @Transactional
    public void deletar(int id){

        log.info("deletando o professor de id {}", id);
        repository.deleteById(id);
    }

    public DisciplinaResponse listarDisciplinaNaQualETitular(int id){
        Professor professor = buscaProfessorPorId(id);
        Disciplina disciplinaEntitie = professor.getDisciplina();
        
        return disciplinaMapper.toResponse(disciplinaEntitie);
    }

    public List<AlunoResponse> listarAlunosTutorados(int idProfessor){
        Professor professor = buscaProfessorPorId(idProfessor);

        List<Aluno> alunosEntities = professor.getAlunos();

        return alunoMapper.toResponse(alunosEntities);
    }

    public Professor buscaProfessorPorId(int id){
        Optional<Professor> professorBuscado = repository.findByIdOptional(id);
        
        if(!professorBuscado.isPresent()){
            throw new NotFoundException();
        }

        return professorBuscado.get();

    }
    
}
