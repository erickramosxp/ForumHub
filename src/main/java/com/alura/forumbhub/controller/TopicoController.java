package com.alura.forumbhub.controller;

import com.alura.forumbhub.domain.topico.*;
import com.alura.forumbhub.domain.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;


    @PostMapping
    @Transactional
    public ResponseEntity criarTopico(@RequestBody @Valid DadosCriarTopico dados, UriComponentsBuilder uriBuilder) {
        var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        var topico = new Topico(dados, usuario);
        topicoRepository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemTopicos(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> listar(@PageableDefault(sort = "data") Pageable paginacao) {
        var topicos = topicoRepository.findByMensagemNotNull(paginacao)
                .map(DadosListagemTopicos::new);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemTopicos(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        Optional<Topico> resposta = topicoRepository.findById(id);
        if (!resposta.isPresent()) {
            throw new EntityNotFoundException("Topico não encontrado");
        }
        var topico = resposta.get();
        topico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemTopicos(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTopico(@PathVariable Long id) {
        Optional<Topico> resposta = topicoRepository.findById(id);
        if(!resposta.isPresent()) {
            throw new EntityNotFoundException("Topico não encontrado");
        }
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
