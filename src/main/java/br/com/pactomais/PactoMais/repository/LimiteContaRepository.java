package br.com.pactomais.PactoMais.repository;

import br.com.pactomais.PactoMais.model.LimiteConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimiteContaRepository extends JpaRepository<LimiteConta, Long> {
}
