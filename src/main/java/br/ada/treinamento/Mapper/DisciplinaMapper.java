package br.ada.treinamento.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import br.ada.treinamento.dto.DisciplinaRequest;
import br.ada.treinamento.dto.DisciplinaResponse;
import br.ada.treinamento.entity.Disciplina;

@ApplicationScoped
public class DisciplinaMapper {
    
    public List<DisciplinaResponse> toResponse(List<Disciplina> listOfDisciplinas) {

        if (Objects.isNull(listOfDisciplinas)) return new ArrayList<>();

        return listOfDisciplinas.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public DisciplinaResponse toResponse(Disciplina entity) {

        if (Objects.isNull(entity)) return null;
            
        return  DisciplinaResponse.builder().id(entity.getId())
        .cargaHoraria(entity.getCargaHoraria()).nome(entity.getNome())
        .professorTitular(Objects.isNull(entity.getTitular()) ? "": entity.getTitular().getNome()).build();
    }

    public Disciplina toEntity(DisciplinaRequest request) {
         if (Objects.isNull(request)) {
             return null;
         } else {
             return Disciplina.builder()
             .nome(request.getNome()).cargaHoraria(request.getCargaHoraria())
             .nome(request.getNome()).build();
         }
    }
}
