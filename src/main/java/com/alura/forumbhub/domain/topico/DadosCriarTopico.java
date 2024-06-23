package com.alura.forumbhub.domain.topico;

import com.alura.forumbhub.domain.Curso;

public record DadosCriarTopico(
        String titulo,
        String mensagem,
        Long idUsuario,
        Curso curso
) {
}
