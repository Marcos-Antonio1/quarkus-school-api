package br.ada.treinamento.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
@Table(name = "Aluno")
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 4, message = "O nome tem que ter no mínimo 4 caracteres")
    private String nome;
    @NotBlank(message = "A Matricula não pode ser vazio")
    @Size(min = 6, message = "A Matricula tem que ter no mínimo 5 caracteres")
    private String matricula;
    private Character sexo;

    @Column(name = "data_atualizacao",nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor")
    private Professor tutor;

    @PrePersist
    public void PrePersist(){
        setDateTime(LocalDateTime.now());
    }

}
