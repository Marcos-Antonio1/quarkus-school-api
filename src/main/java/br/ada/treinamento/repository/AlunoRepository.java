package br.ada.treinamento.repository;

import javax.enterprise.context.ApplicationScoped;
import br.ada.treinamento.entity.AlunoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class AlunoRepository implements PanacheRepositoryBase<AlunoEntity,Integer> {
    
}
