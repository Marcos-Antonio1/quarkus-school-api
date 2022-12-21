package br.ada.treinamento.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.ada.treinamento.dto.AlunoDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class AlunoService {
    
    public List<AlunoDto> retrieveAll(){
        log.info("listando alunos");

        return List.of(
            AlunoDto.builder()
            .id(1)
            .nome("Antonio Marques")
            .matricula("1232")
            .sexo('m')
            .build(),

            AlunoDto.builder()
            .id(2)
            .nome("Rafaela Nunes")
            .matricula("3241")
            .sexo('f')
            .build()
            
            );
    }

    public AlunoDto getById(int id){
        log.info("listando o Aluno {}", id);

        return AlunoDto.builder().id(id)
            .nome("Aluno de "+ id)
            .build();

    }

    public void save(AlunoDto AlunoDto){
        log.info("Cadastrando Aluno {} ", AlunoDto);
    }

    public void alterar(int id, AlunoDto AlunoDto){
        log.info("atualizando o Aluno de id {}", id);
    }

    public void deletar(int id){
        log.info("deletando o Aluno de id {}", id);
    }
    
}
