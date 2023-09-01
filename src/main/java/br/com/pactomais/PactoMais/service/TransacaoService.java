package br.com.pactomais.PactoMais.service;

import br.com.pactomais.PactoMais.dto.Transacao.TransacaoRequest;
import br.com.pactomais.PactoMais.dto.Transacao.TransacaoResponse;
import br.com.pactomais.PactoMais.model.Conta;
import br.com.pactomais.PactoMais.model.Operacao;
import br.com.pactomais.PactoMais.model.Transacao;
import br.com.pactomais.PactoMais.repository.ContaRepository;
import br.com.pactomais.PactoMais.repository.OperacaoRepository;
import br.com.pactomais.PactoMais.repository.TransacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;


@Service
public class TransacaoService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private OperacaoRepository operacaoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private LimiteContaService limiteContaService;

    public ResponseEntity<?> createTransacao(TransacaoRequest transacaoRequest) {
        Transacao transacao = new Transacao();

        if(transacaoRequest.getValor() == null ||
                transacaoRequest.getConta_id() == null ||
                transacaoRequest.getTipo_operacao_id() == null
        ){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Field's conta_id, tipo_operacao_id and valor is required!");
        }

        try {
            Conta conta = contaRepository.getReferenceById(transacaoRequest.getConta_id());
            if(conta.getNumero() != null) {
                transacao.setConta(conta);
            }
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("conta_id not exist!");
        }

        try {
            Operacao operacao = operacaoRepository.getReferenceById(transacaoRequest.getTipo_operacao_id());
            if(operacao.getDescricao() != null){
                transacao.setTipoOperacao(operacao);
            }
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("tipo_operacao_id not exist!");
        }

        String tipoDeTransacao = transacao.getTipoOperacao().getDescricao();

        transacaoRequest.setValor(Math.abs(transacaoRequest.getValor()));

        if(Objects.equals(tipoDeTransacao, "PAGAMENTO")){
            transacao.setValor(transacaoRequest.getValor());
        }else{
            transacao.setValor(- transacaoRequest.getValor());
        }

        transacao.setDataTransacao(LocalDateTime.now());
        transacaoRepository.save(transacao);
        TransacaoResponse transacaoResponse = transacaoToResponse(transacao);

        if(!limiteContaService.alterLimite(transacao)){
            return ResponseEntity.badRequest().body("Rejected!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoResponse);
    }

    public TransacaoResponse transacaoToResponse(Transacao transacao){
        return new TransacaoResponse(
                transacao.getId(),
                transacao.getConta().getId(),
                transacao.getTipoOperacao().getId(),
                transacao.getValor(),
                transacao.getDataTransacao()
        );
    }
}
