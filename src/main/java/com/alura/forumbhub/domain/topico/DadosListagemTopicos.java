package com.alura.forumbhub.domain.topico;

import com.alura.forumbhub.domain.Curso;

import java.time.LocalDateTime;

public record DadosListagemTopicos(
    Long id,
    String titulo,
    String mensagem,
    LocalDateTime data,
    String status,
    Curso curso
) {
    public DadosListagemTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(),
                topico.getData(), topico.getStatus(), topico.getCurso());
    }
}
