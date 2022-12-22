package br.ada.treinamento.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import br.ada.treinamento.dto.AlunoRequest;
import br.ada.treinamento.dto.AlunoResponse;
import br.ada.treinamento.entity.AlunoEntity;
import br.ada.treinamento.repository.AlunoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class AlunoService {

    private AlunoRepository repository;

    @Inject
    public AlunoService(AlunoRepository repository){
        this.repository = repository;
    }
    
    public List<AlunoResponse> retrieveAll(){
        log.info("listando alunos");

        List<AlunoEntity> alunosEntitie = repository.listAll();
        
        return alunosEntitie.stream().map(aluno -> 
            AlunoResponse.builder().id(aluno.getId())
            .nome(aluno.getNome())
            .matricula(aluno.getMatricula())
            .sexo(aluno.getSexo()).build()
        ).collect(Collectors.toList());

    }

    public AlunoResponse getById(int id){
        log.info("listando o Aluno {}", id);

        Optional<AlunoEntity> alunoBuscado = repository.findByIdOptional(id);

        if(!alunoBuscado.isPresent()){
            throw new NotFoundException();
        }

        AlunoEntity aluno = alunoBuscado.get();

        return AlunoResponse.builder().id(aluno.getId())
        .matricula(aluno.getMatricula())
        .nome(aluno.getNome())
        .sexo(aluno.getSexo()).build();
        
    }


    @Transactional
    public void save(AlunoRequest alunoRequest){
        log.info("Cadastrando Aluno {} ", alunoRequest);

        AlunoEntity aluno = AlunoEntity.builder()
            .nome(alunoRequest.getNome())
            .matricula(alunoRequest.getMatricula())
            .sexo(alunoRequest.getSexo())
            .build();

        repository.persist(aluno);
    }

    @Transactional
    public void alterar(int id, AlunoRequest alunoRequest){

        log.info("atualizando o Aluno de id {}", id);
        
        Optional<AlunoEntity> alunoBuscado = repository.findByIdOptional(id);

        if(!alunoBuscado.isPresent()){
            throw new NotFoundException();
        }

        AlunoEntity aluno = alunoBuscado.get();
        aluno.setNome(alunoRequest.getNome());
        repository.persist(aluno);
    }

    @Transactional
    public void deletar(int id){
        log.info("deletando o Aluno de id {}", id);
        repository.deleteById(id);
    }
    
}
