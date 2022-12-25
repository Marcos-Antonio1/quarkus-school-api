package br.ada.treinamento.repository;

import javax.enterprise.context.ApplicationScoped;

import br.ada.treinamento.entity.Professor;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class ProfessorRepository implements PanacheRepositoryBase<Professor,Integer>{
    
}
