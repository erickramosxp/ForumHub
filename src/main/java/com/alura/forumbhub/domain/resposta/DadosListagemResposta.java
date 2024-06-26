package com.alura.forumbhub.domain.resposta;

import com.alura.forumbhub.domain.usuario.DadosListagemUsuarios;
import com.alura.forumbhub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosListagemResposta(
        Long id,
        String mensagem,
        LocalDateTime data,
        DadosListagemUsuarios usuario
) {
    public DadosListagemResposta(Resposta resposta) {
        this(resposta.getId(), resposta.getMensagem(), resposta.getData(),
                new DadosListagemUsuarios(resposta.getUsuario()));
    }
}
