package com.alura.forumbhub.domain.usuario;

import com.alura.forumbhub.domain.Perfil;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record DadosCadastroUsuario(
    String nome,
    String email,
    String senha,
    Perfil perfil
) {

}
