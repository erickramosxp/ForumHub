package com.alura.forumbhub.controller;

import com.alura.forumbhub.domain.resposta.DadosListagemResposta;
import com.alura.forumbhub.domain.resposta.DadosRegistoResposta;
import com.alura.forumbhub.domain.resposta.Resposta;
import com.alura.forumbhub.domain.resposta.RespostasRepository;
import com.alura.forumbhub.domain.topico.DadosListagemTopicos;
import com.alura.forumbhub.domain.topico.Topico;
import com.alura.forumbhub.domain.topico.TopicoRepository;
import com.alura.forumbhub.domain.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/topicos/{id}/resposta")
public class RespostaController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    RespostasRepository respostasRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarResposta(@PathVariable Long id, @RequestBody DadosRegistoResposta dados, UriComponentsBuilder uriBuilder) {
        var topico = topicoRepository.getReferenceById(id);
        var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        Resposta resposta = new Resposta(dados, usuario);
        topico.addResposta(resposta);
        respostasRepository.save(resposta);

        var uri = uriBuilder.path("/topicos/" + id + "/{id}").buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemResposta(resposta));
    }

    @GetMapping("/{idResposta}")
    public ResponseEntity detalharResposta(@PathVariable Long id, @PathVariable Long idResposta){
        Optional<Topico> topico = topicoRepository.findById(id);
        if (!topico.isPresent()) {
            throw new EntityNotFoundException("Topico não encontrado");
        }
        var resposta = respostasRepository.getReferenceById(idResposta);
        return ResponseEntity.ok(new DadosListagemResposta(resposta));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemResposta>> listarTopicos(@PathVariable Long id, Pageable paginacao){
        Optional<Topico> topico = topicoRepository.findById(id);
        if (!topico.isPresent()) {
            throw new EntityNotFoundException("Topico não encontrado");
        }
        var respostas = respostasRepository.findByTopicoId(id, paginacao).map(DadosListagemResposta::new);
        return ResponseEntity.ok(respostas);
    }
}
