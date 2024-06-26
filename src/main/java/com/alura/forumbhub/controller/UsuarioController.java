package com.alura.forumbhub.controller;

import com.alura.forumbhub.domain.usuario.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder){
        var usuario = new Usuario(dados);
        repository.save(usuario);

        var uri = uriBuilder.path("/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemUsuarios(usuario));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarUsuario dados) {
//        Optional<Usuario> user = repository.findById(dados.id());
//        if (!user.isPresent()) {
//            throw new EntityNotFoundException("Usuario não encontrado");
//        }
        var usuario = repository.getReferenceById(dados.id());
        usuario.atulizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemUsuarios(usuario));
    }
    
    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuarios>> listar(Pageable paginacao) {
        var usuarios = repository.retornarTodosUsuarios(paginacao)
                .map(DadosListagemUsuarios::new);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity detaharUsuario(@PathVariable Long id) {
        var usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemUsuarios(usuario));
    }

}
