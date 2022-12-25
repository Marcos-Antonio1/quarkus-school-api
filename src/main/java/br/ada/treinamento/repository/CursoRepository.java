package br.ada.treinamento.repository;

import javax.enterprise.context.ApplicationScoped;

import br.ada.treinamento.entity.Curso;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class CursoRepository implements PanacheRepositoryBase<Curso,Integer> {
    
}
