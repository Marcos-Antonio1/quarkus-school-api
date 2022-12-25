package br.ada.treinamento.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class ProfessorRequest {
    
    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 4, message = "O nome tem que ter no mínimo 4 caracteres")
    private String nome;
    @NotBlank(message = "O titulo não pode ser vazio")
    private String titulo;
    private char sexo;
    
}
