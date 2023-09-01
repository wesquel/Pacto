package br.com.pactomais.PactoMais.repository;

import br.com.pactomais.PactoMais.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    Conta findByNumero(Long numero);
}
