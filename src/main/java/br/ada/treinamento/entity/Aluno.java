package br.ada.treinamento.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Aluno")
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "O nome não pode ser vazio")
    @Min(value = 4, message="O nome tem que ter no mínimo 4 caracteres")
    private String nome;
    @NotBlank(message = "A Matricula não pode ser vazio")
    @Min(value = 6, message="A Matricula tem que ter no mínimo 5 caracteres")
    private String matricula;
    private Character sexo;


}
