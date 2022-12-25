package br.ada.treinamento.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

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
    @Size(min = 4, message = "O nome tem que ter no mínimo 4 caracteres")
    private String nome;
    @Positive(message = "a carga horaria tem que ser um valor maior que 0")
    private int cargaHoraria; 

}
