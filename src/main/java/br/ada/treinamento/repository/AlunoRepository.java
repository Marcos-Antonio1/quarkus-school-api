package br.ada.treinamento.repository;

import javax.enterprise.context.ApplicationScoped;
import br.ada.treinamento.entity.Aluno;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class AlunoRepository implements PanacheRepositoryBase<Aluno,Integer> {
    
}
