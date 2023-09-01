package br.com.pactomais.PactoMais.dto.Transacao;

import java.time.LocalDateTime;

public record TransacaoResponse(Long id, Long contaId, Long operacaoId, Double valor, LocalDateTime dataTransacao) {
}

