package br.ada.treinamento.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlunoRequest {
    
    @NotBlank(message = "O nome não pode ser vazio")
    @Min(value = 4, message="O nome tem que ter no mínimo 4 caracteres")
    private String nome;
    @NotBlank(message = "A Matricula não pode ser vazio")
    @Min(value = 6, message="A Matricula tem que ter no mínimo 5 caracteres")
    private String matricula;
    private char sexo;
}
