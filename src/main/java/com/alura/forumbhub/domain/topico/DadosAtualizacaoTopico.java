package com.alura.forumbhub.domain.topico;

import com.alura.forumbhub.domain.Curso;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        Long id,
        String titulo,
    String mensagem,
    String status,
    Curso curso
) {
}
