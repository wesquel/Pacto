package br.com.pactomais.PactoMais.controller;

import br.com.pactomais.PactoMais.dto.Conta.ContaRequest;
import br.com.pactomais.PactoMais.dto.Conta.ContaResponse;
import br.com.pactomais.PactoMais.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return contaService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createConta(@RequestBody ContaRequest contaRequest){
        return contaService.createConta(contaRequest);
    }
}
