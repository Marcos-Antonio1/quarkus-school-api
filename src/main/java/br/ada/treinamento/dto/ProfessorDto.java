package br.ada.treinamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDto {
    
    private int id;
    private String nome;
    private String titulo;
    private Character sexo;

}
