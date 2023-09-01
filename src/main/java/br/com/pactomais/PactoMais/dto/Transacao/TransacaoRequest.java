package br.com.pactomais.PactoMais.dto.Transacao;

import java.time.LocalDateTime;

public class TransacaoRequest {
    private Long conta_id;
    private Long tipo_operacao_id;
    private Double valor;

    public Long getConta_id() {
        return conta_id;
    }

    public void setConta_id(Long conta_id) {
        this.conta_id = conta_id;
    }

    public Long getTipo_operacao_id() {
        return tipo_operacao_id;
    }

    public void setTipo_operacao_id(Long tipo_operacao_id) {
        this.tipo_operacao_id = tipo_operacao_id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
