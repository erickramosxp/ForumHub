package com.alura.forumbhub.controller;

import com.alura.forumbhub.domain.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroUsuario dados){
        System.out.println(dados);
        var usuario = new Usuario(dados);
        repository.save(usuario);
    }

    @GetMapping
    public String listar() {
        var usuarios = repository.findAll().stream()
                .map(DadosListagemUsuarios::new);
       // List<Usuario> usuarios = repository.findAll();
        usuarios.forEach(System.out::println);
     //   System.out.println(usuarios);
        return "Hello mundo";
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarUsuario dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atulizarInformacoes(dados);
        System.out.println(usuario.getEmail());
    }

}
