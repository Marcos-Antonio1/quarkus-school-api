package br.ada.treinamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDto {
    
    private int id;
    private String nome;
    private String matricula;
    private Character sexo;
}
