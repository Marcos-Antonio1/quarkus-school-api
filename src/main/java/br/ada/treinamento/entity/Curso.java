package br.ada.treinamento.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
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
@Entity
@Table(name = "Curso")
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 4, message = "O nome tem que ter no mínimo 4 caracteres")
    private String nome;
    @NotBlank(message = "A Descrição não pode ser vazio")
    private String descricao;
    @Positive(message = "A duração tem que ser um valor maior que 0")
    private int duracao;

    @Column(name = "data_atualizacao",nullable = false)
    private LocalDateTime dateTime;

    @PrePersist
    public void PrePersist(){
        setDateTime(LocalDateTime.now());
    }


}
