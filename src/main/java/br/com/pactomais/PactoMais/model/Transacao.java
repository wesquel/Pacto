package br.com.pactomais.PactoMais.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Conta_id")
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "Operacao_id")
    private Operacao operacao;

    private Double valor;

    private LocalDateTime dataTransacao;

    public Transacao() {
    }

    public Transacao(Conta conta, Operacao operacao, Double valor, LocalDateTime dataTransacao) {
        this.conta = conta;
        this.operacao = operacao;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
    }

    public Long getId() {
        return id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Operacao getTipoOperacao() {
        return operacao;
    }

    public void setTipoOperacao(Operacao tipoOperacao) {
        this.operacao = tipoOperacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}

