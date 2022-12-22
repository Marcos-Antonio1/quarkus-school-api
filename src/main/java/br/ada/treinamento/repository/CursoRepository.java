package br.ada.treinamento.repository;

import javax.enterprise.context.ApplicationScoped;

import br.ada.treinamento.entity.CursoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class CursoRepository implements PanacheRepositoryBase<CursoEntity,Integer> {
    
}
