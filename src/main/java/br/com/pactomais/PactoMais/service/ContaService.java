package br.com.pactomais.PactoMais.service;

import br.com.pactomais.PactoMais.dto.Conta.ContaRequest;
import br.com.pactomais.PactoMais.dto.Conta.ContaResponse;
import br.com.pactomais.PactoMais.model.Conta;
import br.com.pactomais.PactoMais.model.LimiteConta;
import br.com.pactomais.PactoMais.repository.ContaRepository;
import br.com.pactomais.PactoMais.repository.LimiteContaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.aspectj.bridge.Version.getTime;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private LimiteContaRepository limiteContaRepository;

    public ResponseEntity<?> getById(Long id) {
        try {
            Conta conta = contaRepository.getReferenceById(id);
            var contaResponse = new ContaResponse(conta.getId(), conta.getNumero());
            return ResponseEntity.ok().body(contaResponse);
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (MethodArgumentTypeMismatchException e){
            return ResponseEntity.badRequest().body("Invalid value!");
        }
    }

    public ResponseEntity<?> createConta(ContaRequest contaRequest) {
        Conta conta;

        if(contaRequest.getNumero_conta() == null){
            return ResponseEntity.badRequest().body("Field numero_conta is Required!");
        }

        try{
            conta = contaRepository.findByNumero(contaRequest.getNumero_conta());
        }catch (IncorrectResultSizeDataAccessException e){
            conta = new Conta();
        }

        if(conta != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Existing account!" );
        }

        conta = new Conta();
        conta.setNumero(contaRequest.getNumero_conta());
        contaRepository.save(conta);

        LimiteConta limiteConta = new LimiteConta();
        limiteConta.setConta(conta);
        limiteConta.setLimite(5000.0);
        limiteConta.setData_limite(LocalDate.now());
        limiteContaRepository.save(limiteConta);


        return ResponseEntity.ok().body(contaToResponse(conta));

    }

    public ContaResponse contaToResponse(Conta conta){
        return new ContaResponse(
                conta.getId(),
                conta.getNumero()
        );
    }
}
