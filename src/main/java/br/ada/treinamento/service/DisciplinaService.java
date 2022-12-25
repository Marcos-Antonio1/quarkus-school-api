package br.ada.treinamento.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import br.ada.treinamento.dto.DisciplinaRequest;
import br.ada.treinamento.dto.DisciplinaResponse;
import br.ada.treinamento.entity.Disciplina;
import br.ada.treinamento.repository.DisciplinaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class DisciplinaService {

    private DisciplinaRepository repository;
    
    @Inject
    public DisciplinaService(DisciplinaRepository repository){
        this.repository = repository;
    }

    public List<DisciplinaResponse> retrieveAll(){
        log.info("listando disciplinas");
        List<Disciplina> disciplinasEntitie  = repository.listAll();

        return disciplinasEntitie.stream()
        .map(dis -> DisciplinaResponse.builder().id(dis.getId())
        .nome(dis.getNome()).cargaHoraria(dis.getCargaHoraria()).build()).collect(Collectors.toList());
        
    }


    public DisciplinaResponse getById(int id){

        log.info("listando o Disciplina {}", id);
        Optional<Disciplina> disclipinaBuscada = repository.findByIdOptional(id);
        
        if(!disclipinaBuscada.isPresent()){
            throw new NotFoundException();
        }

        Disciplina discliplina = disclipinaBuscada.get();

        return DisciplinaResponse.builder().id(discliplina.getId())
        .nome(discliplina.getNome()).cargaHoraria(discliplina.getCargaHoraria()).build();

    }

    @Transactional
    public void save(DisciplinaRequest disciplinaRequest){
        log.info("Cadastrando Aluno {} ", disciplinaRequest);

        Disciplina disciplina = Disciplina.builder()
        .nome(disciplinaRequest.getNome())
        .cargaHoraria(disciplinaRequest.getCargaHoraria()).build();

        repository.persist(disciplina);
    }

    @Transactional
    public void alterar(int id, DisciplinaRequest disciplinaRequest){

        log.info("atualizando Disciplina de id {}", id);
        
        Optional<Disciplina> disciplinaBuscado = repository.findByIdOptional(id);

        if(!disciplinaBuscado.isPresent()){
            throw new NotFoundException();
        }

        Disciplina disciplina = disciplinaBuscado.get();
        disciplina.setNome(disciplinaRequest.getNome());
        disciplina.setCargaHoraria(disciplinaRequest.getCargaHoraria());
        repository.persist(disciplina); 
    }

    @Transactional
    public void deletar(int id){
        log.info("deletando disciplina de id {}", id);
        repository.deleteById(id);
    }
}
