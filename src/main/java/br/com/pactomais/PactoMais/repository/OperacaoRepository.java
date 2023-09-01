package br.com.pactomais.PactoMais.repository;

import br.com.pactomais.PactoMais.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
    Operacao findByDescricao(String descricao);
}
