package br.ada.treinamento.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Professor")
public class Professor  implements Serializable {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "O nome não pode ser vazio")
    @Min(value = 4, message="O nome tem que ter no mínimo 4 caracteres")
    private String nome;
    @NotBlank(message = "O titulo não pode ser vazio")
    private String titulo;
    private Character sexo;

    @Column(name = "data_atualizacao",nullable = false)
    private LocalDateTime dateTime;

    @PrePersist
    public void PrePersist(){
        setDateTime(LocalDateTime.now());
    }


}
