package br.com.pactomais.PactoMais.controller;

import br.com.pactomais.PactoMais.dto.Transacao.TransacaoRequest;
import br.com.pactomais.PactoMais.dto.Transacao.TransacaoResponse;
import br.com.pactomais.PactoMais.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    @Autowired
    TransacaoService transacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createTransacao(@RequestBody TransacaoRequest transacaoRequest){
        return transacaoService.createTransacao(transacaoRequest);
    }
}
