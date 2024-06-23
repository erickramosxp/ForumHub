package com.alura.forumbhub.domain.usuario;

import com.alura.forumbhub.domain.Perfil;

public record DadosListagemUsuarios(
        Long id,
        String nome,
        String email,
        Perfil perfil
) {
    public DadosListagemUsuarios(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getPerfil());
    }
}
