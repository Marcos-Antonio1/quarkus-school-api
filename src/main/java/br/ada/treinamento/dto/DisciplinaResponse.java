package br.ada.treinamento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaResponse {

    
    private int id;
    private String nome;
    private int cargaHoraria;
    private ProfessorResponse professorTitular;

}
