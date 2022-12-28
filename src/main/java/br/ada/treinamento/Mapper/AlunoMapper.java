package br.ada.treinamento.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import br.ada.treinamento.dto.AlunoRequest;
import br.ada.treinamento.dto.AlunoResponse;
import br.ada.treinamento.entity.Aluno;


@ApplicationScoped
public class AlunoMapper {
    public List<AlunoResponse> toResponse(List<Aluno> listOfAlunos) {

        if (Objects.isNull(listOfAlunos)) return new ArrayList<>();
        

        return listOfAlunos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public AlunoResponse toResponse(Aluno entity) {

        if (Objects.isNull(entity)) return null;

        return  AlunoResponse.builder()
                    .id(entity.getId())
                    .nome(entity.getNome())
                    .matricula(entity.getMatricula())
                    .tutor(Objects.isNull(entity.getTutor()) ? "" : entity.getTutor().getNome())
                    .sexo(entity.getSexo()).build();
    }

    public Aluno toEntity(AlunoRequest request) {
         if (Objects.isNull(request)) {
             return null;
         } else {
             return Aluno.builder()
                    .nome(request.getNome())
                    .matricula(request.getMatricula())
                    .sexo(request.getSexo()).build();
         }
    }
}
