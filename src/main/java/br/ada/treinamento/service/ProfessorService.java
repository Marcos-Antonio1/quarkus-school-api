package br.ada.treinamento.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import br.ada.treinamento.dto.ProfessorRequest;
import br.ada.treinamento.dto.ProfessorResponse;
import br.ada.treinamento.entity.CursoEntity;
import br.ada.treinamento.entity.ProfessorEntity;
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
        List<ProfessorEntity> professorEntitie = repository.listAll();

        return professorEntitie.stream().map(professor -> ProfessorResponse.builder()
        .id(professor.getId()).nome(professor.getNome()).titulo(professor.getTitulo()).sexo(professor.getSexo())
        .build()
        ).collect(Collectors.toList());
        
    }

    public ProfessorResponse getById(int id){
        
        log.info("listando o professor {}", id);
        ProfessorEntity professor = buscaProfessorPorId(id);

        return ProfessorResponse.builder()
        .id(professor.getId()).nome(professor.getNome()).titulo(professor.getTitulo()).sexo(professor.getSexo())
        .build();
        

    }

    @Transactional
    public void save(ProfessorRequest professorRequest){
        
        log.info("Cadastrando professor {} ", professorRequest);
        ProfessorEntity professor = ProfessorEntity.builder().nome(professorRequest.getNome())
        .titulo(professorRequest.getTitulo())
        .sexo(professorRequest.getSexo())
        .build();

        repository.persist(professor);

    }

    @Transactional
    public void alterar(int id, ProfessorRequest professorRequest){
        
        log.info("atualizando o professor de id {}", id);
        ProfessorEntity professor = buscaProfessorPorId(id);

        professor.setNome(professorRequest.getNome());
        professor.setTitulo(professorRequest.getTitulo());

        repository.persist(professor);
    }

    @Transactional
    public void deletar(int id){

        log.info("deletando o professor de id {}", id);
        repository.deleteById(id);
    }

    private ProfessorEntity buscaProfessorPorId(int id){
        Optional<ProfessorEntity> professorBuscado = repository.findByIdOptional(id);
        
        if(!professorBuscado.isPresent()){
            throw new NotFoundException();
        }

        return professorBuscado.get();

    }

}
