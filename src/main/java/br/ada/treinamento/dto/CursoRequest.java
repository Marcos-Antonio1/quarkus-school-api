package br.ada.treinamento.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CursoRequest {
    
    @NotBlank(message = "O nome não pode ser vazio")
    @Min(value = 4, message="O nome tem que ter no mínimo 4 caracteres")
    private String nome;
    @NotBlank(message = "A Descrição não pode ser vazio")
    private String descricao;
    @Positive(message = "A duração tem que ser um valor maior que 0")
    private int duracao;

}
