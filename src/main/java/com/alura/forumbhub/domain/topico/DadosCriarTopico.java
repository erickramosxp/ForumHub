package com.alura.forumbhub.domain.topico;

import com.alura.forumbhub.domain.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCriarTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        Long idUsuario,
        @NotNull
        Curso curso
) {
}
