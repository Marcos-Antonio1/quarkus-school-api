package br.ada.treinamento.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.ada.treinamento.dto.CursoDto;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ApplicationScoped
public class CursoService {
    
    public List<CursoDto> retrieveAll(){
        log.info("listando Cursos");

        return List.of(
            CursoDto.builder()
            .id(1)
            .descricao("matemática")
            .duracao(4)
            .build(),

            CursoDto.builder()
            .id(12)
            .descricao("economia")
            .duracao(4)
            .build()
            
            );
    }

    public CursoDto getById(int id){
        log.info("listando o Curso {}", id);

        return CursoDto.builder().id(id)
            .nome("Curso de "+ id)
            .build();

    }

    public void save(CursoDto cursoDto){
        log.info("Cadastrando Curso {} ", cursoDto);
    }

    public void alterar(int id, CursoDto cursoDto){
        log.info("atualizando o Curso de id {}", id);
    }

    public void deletar(int id){
        log.info("deletando o Curso de id {}", id);
    }

}
