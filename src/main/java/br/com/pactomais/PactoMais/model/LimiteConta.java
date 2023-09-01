package br.com.pactomais.PactoMais.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class LimiteConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double limite;
    private LocalDate data_limite;

    @OneToOne
    @JoinColumn(name = "Conta_id")
    private Conta conta;

    public LimiteConta() {
    }

    public LimiteConta(Long id, double limite, LocalDate data_limite, Conta conta) {
        this.id = id;
        this.limite = limite;
        this.data_limite = data_limite;
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public LocalDate getData_limite() {
        return data_limite;
    }

    public void setData_limite(LocalDate data_limite) {
        this.data_limite = data_limite;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
