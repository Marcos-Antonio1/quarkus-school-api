package br.ada.treinamento.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import br.ada.treinamento.dto.ProfessorRequest;
import br.ada.treinamento.dto.ProfessorResponse;
import br.ada.treinamento.entity.Professor;



@ApplicationScoped
public class ProfessorMapper {
    public List<ProfessorResponse> toResponse(List<Professor> listOfProfessors) {

        if (Objects.isNull(listOfProfessors)) return new ArrayList<>();

        return listOfProfessors.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ProfessorResponse toResponse(Professor entity) {

        if (Objects.isNull(entity)) return null;

        return  ProfessorResponse.builder()
                    .id(entity.getId())
                    .nome(entity.getNome())
                    .titulo(entity.getTitulo())
                    .sexo(entity.getSexo()).build();
    }

    public Professor toEntity(ProfessorRequest request) {
         if (Objects.isNull(request)) {
             return null;
         } else {
             return Professor.builder()
                    .nome(request.getNome())
                    .titulo(request.getTitulo())
                    .sexo(request.getSexo()).build();
         }
    }
}
