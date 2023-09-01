package br.com.pactomais.PactoMais.service;

import br.com.pactomais.PactoMais.model.LimiteConta;
import br.com.pactomais.PactoMais.model.Transacao;
import br.com.pactomais.PactoMais.repository.LimiteContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LimiteContaService {

    @Autowired
    private LimiteContaRepository limiteContaRepository;

    public boolean alterLimite(Transacao transacao){

        LimiteConta limiteConta = limiteContaRepository.getReferenceById(transacao.getConta().getId());
        String tipoDeTransacao = transacao.getTipoOperacao().getDescricao();

        if(Objects.equals(tipoDeTransacao, "PAGAMENTO")){
            limiteConta.setLimite(transacao.getValor() + limiteConta.getLimite());
            limiteContaRepository.save(limiteConta);
            return true;
        }else{
            if (limiteConta.getLimite() >= Math.abs(transacao.getValor())){
                limiteConta.setLimite(limiteConta.getLimite() + transacao.getValor());
                limiteContaRepository.save(limiteConta);
                return true;
            }
        }
        return false;
    }

}
