package br.ada.treinamento.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import br.ada.treinamento.dto.CursoRequest;
import br.ada.treinamento.dto.CursoResponse;
import br.ada.treinamento.entity.Curso;


@ApplicationScoped
public class CursoMapper {
    
    public List<CursoResponse> toResponse(List<Curso> listOfCursos) {

        if (Objects.isNull(listOfCursos)) return new ArrayList<>();
        

        return listOfCursos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public CursoResponse toResponse(Curso entity) {

        if (Objects.isNull(entity)) return null;

        return  CursoResponse.builder()
                    .id(entity.getId())
                    .descricao(entity.getDescricao())
                    .duracao(entity.getDuracao())
                    .nome(entity.getNome()).build();
    }

    public Curso toEntity(CursoRequest request) {
         if (Objects.isNull(request)) {
             return null;
         } else {
             return Curso.builder()
                    .nome(request.getNome())
                    .descricao(request.getDescricao())
                    .duracao(request.getDuracao())
                    .build();
         }
    }
}
