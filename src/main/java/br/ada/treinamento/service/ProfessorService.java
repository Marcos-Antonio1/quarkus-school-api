package br.ada.treinamento.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.NotFoundException;

import br.ada.treinamento.dto.ProfessorRequest;
import br.ada.treinamento.dto.ProfessorResponse;
import br.ada.treinamento.entity.Curso;
import br.ada.treinamento.entity.Professor;
import br.ada.treinamento.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ApplicationScoped
public class ProfessorService {

    private ProfessorRepository repository;
    
    @Inject
    public ProfessorService(ProfessorRepository repository){
        this.repository = repository;
    }
    
    public List<ProfessorResponse> retrieveAll(){

        log.info("listando professores");
        List<Professor> professorEntitie = repository.listAll();

        return professorEntitie.stream().map(professor -> ProfessorResponse.builder()
        .id(professor.getId()).nome(professor.getNome()).titulo(professor.getTitulo()).sexo(professor.getSexo())
        .build()
        ).collect(Collectors.toList());
        
    }

    public ProfessorResponse getById(int id){
        
        log.info("listando o professor {}", id);
        Professor professor = buscaProfessorPorId(id);

        return ProfessorResponse.builder()
        .id(professor.getId()).nome(professor.getNome()).titulo(professor.getTitulo()).sexo(professor.getSexo())
        .build();
        

    }

    @Transactional
    public void save(@Valid ProfessorRequest professorRequest){
        
        log.info("Cadastrando professor {} ", professorRequest);
        Professor professor = Professor.builder().nome(professorRequest.getNome())
        .titulo(professorRequest.getTitulo())
        .sexo(professorRequest.getSexo())
        .build();

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

    private Professor buscaProfessorPorId(int id){
        Optional<Professor> professorBuscado = repository.findByIdOptional(id);
        
        if(!professorBuscado.isPresent()){
            throw new NotFoundException();
        }

        return professorBuscado.get();

    }

}
