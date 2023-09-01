package br.com.pactomais.PactoMais.config.dataInitizer;

import br.com.pactomais.PactoMais.model.Operacao;
import br.com.pactomais.PactoMais.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializerData implements CommandLineRunner {

    @Autowired
    OperacaoRepository operacaoRepository;

    @Override
    public void run(String... args) throws Exception {
        Operacao operacao1 = new Operacao("COMPRA A VISTA");
        Operacao operacao2 = new Operacao("COMPRA PARCELADA");
        Operacao operacao3 = new Operacao("SAQUE");
        Operacao operacao4 = new Operacao("PAGAMENTO");

        if(checkExistOperacao(operacao1.getDescricao())){
            operacaoRepository.save(operacao1);
        }
        if(checkExistOperacao(operacao2.getDescricao())){
            operacaoRepository.save(operacao2);
        }
        if(checkExistOperacao(operacao3.getDescricao())){
            operacaoRepository.save(operacao3);
        }
        if(checkExistOperacao(operacao4.getDescricao())){
            operacaoRepository.save(operacao4);
        }
    }

    public boolean checkExistOperacao(String descricao){
        return operacaoRepository.findByDescricao(descricao) == null;
    }
}
