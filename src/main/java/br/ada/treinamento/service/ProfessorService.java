package br.ada.treinamento.service;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.ada.treinamento.dto.ProfessorDto;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ApplicationScoped
public class ProfessorService {
    
    public List<ProfessorDto> retrieveAll(){

        log.info("listando professores");

        return List.of(
            ProfessorDto.builder().id(1)
                .nome("Rogerio Silva")
                .sexo('m')
                .build(),
            ProfessorDto.builder().id(2)
                .nome("Maria Rodrigues")
                .sexo('f')
                .build()
        );
    }

    public ProfessorDto getById(int id){
        log.info("listando o professor {}", id);

        return ProfessorDto.builder().id(id)
            .nome("Professor de "+ id)
            .build();

    }

    public void save(ProfessorDto professorDto){
        log.info("Cadastrando professor {} ", professorDto);
    }

    public void alterar(int id, ProfessorDto professorDto){
        log.info("atualizando o professor de id {}", id);
    }

    public void deletar(int id){
        log.info("deletando o professor de id {}", id);
    }

}
