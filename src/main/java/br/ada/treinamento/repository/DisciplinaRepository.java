package br.ada.treinamento.repository;

import javax.enterprise.context.ApplicationScoped;

import br.ada.treinamento.entity.Disciplina;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class DisciplinaRepository implements PanacheRepositoryBase<Disciplina,Integer> {
    
}
