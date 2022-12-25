package br.ada.treinamento.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.PrePersist;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Professor")
public class Disciplina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "O nome da disciplina não pode estar vazio")
    private String nome;
    @Positive(message = "a carga horaria tem que ser um valor maior que 0")
    private int cargaHoraria;

    @Column(name = "data_atualizacao",nullable = false)
    private LocalDateTime dateTime;

    @PrePersist
    public void PrePersist(){
        setDateTime(LocalDateTime.now());
    }

}
