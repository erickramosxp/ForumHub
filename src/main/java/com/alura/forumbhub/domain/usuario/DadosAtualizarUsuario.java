package com.alura.forumbhub.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(
        @NotNull
        Long id,
        String nome,
        String email
) {
}
