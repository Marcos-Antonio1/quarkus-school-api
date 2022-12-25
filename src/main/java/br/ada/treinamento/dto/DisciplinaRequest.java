package br.ada.treinamento.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaRequest {
    
    @NotBlank(message = "O nome da disciplina não pode estar vazio")
    private String nome;
    @Positive(message = "a carga horaria tem que ser um valor maior que 0")
    private int cargaHoraria; 

}
