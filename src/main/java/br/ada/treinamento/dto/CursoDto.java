package br.ada.treinamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDto {
    
    private int id;
    private String nome;
    private String descricao;
    private int duracao;

}
