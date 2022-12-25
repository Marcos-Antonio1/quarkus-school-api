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
    @Size(min = 4, message = "O nome tem que ter no mínimo 4 caracteres")
    private String nome;
    @NotBlank(message = "A Matricula não pode ser vazio")
    @Size(min = 6, message = "A Matricula tem que ter no mínimo 6 caracteres")
    private String matricula;
    private char sexo;
}
