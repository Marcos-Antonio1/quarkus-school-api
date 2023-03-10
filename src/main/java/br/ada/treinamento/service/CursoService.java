package br.ada.treinamento.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.NotFoundException;

import br.ada.treinamento.Mapper.CursoMapper;
import br.ada.treinamento.dto.CursoRequest;
import br.ada.treinamento.dto.CursoResponse;
import br.ada.treinamento.entity.Curso;
import br.ada.treinamento.repository.CursoRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ApplicationScoped
public class CursoService {
    
    private CursoRepository repository;
    private CursoMapper mapper;

    @Inject
    public CursoService(CursoRepository repository ,CursoMapper mapper){
        this.repository =  repository;
        this.mapper = mapper;
    }

    public List<CursoResponse> retrieveAll(){

        log.info("listando Cursos");
        List<Curso> cursosEntitie = repository.listAll();
        
        return mapper.toResponse(cursosEntitie);
         
    }

    public CursoResponse getById(int id){
        
        log.info("listando o Curso {}", id);

        Curso curso = buscaCursoPorId(id);

        return mapper.toResponse(curso);


    }

    @Transactional
    public void save(@Valid CursoRequest cursoRequest){
        log.info("Cadastrando Curso {} ", cursoRequest);
        
        Curso curso = Curso.builder().nome(cursoRequest.getNome())
        .descricao(cursoRequest.getDescricao()).duracao(cursoRequest.getDuracao()).build();

        repository.persist(curso);
    }

    @Transactional
    public void alterar(int id, @Valid CursoRequest cursoRequest){
        
        log.info("atualizando o Curso de id {}", id);
        Curso curso = buscaCursoPorId(id);
        curso.setDescricao(cursoRequest.getDescricao());
        curso.setNome(cursoRequest.getNome());
        curso.setDuracao(cursoRequest.getDuracao());

        repository.persist(curso);


    }

    @Transactional
    public void deletar(int id){

        log.info("deletando o Curso de id {}", id);
        repository.deleteById(id);

    }

    private Curso buscaCursoPorId(int id){
        Optional<Curso> cursoBuscado = repository.findByIdOptional(id);
        
        if(!cursoBuscado.isPresent()){
            throw new NotFoundException();
        }

        return cursoBuscado.get();

    }

}
