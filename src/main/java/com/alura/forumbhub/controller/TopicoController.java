package com.alura.forumbhub.controller;

import com.alura.forumbhub.domain.topico.DadosCriarTopico;
import com.alura.forumbhub.domain.topico.DadosListagemTopicos;
import com.alura.forumbhub.domain.topico.Topico;
import com.alura.forumbhub.domain.topico.TopicoRepository;
import com.alura.forumbhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;


    @PostMapping
    public void criarTopico(@RequestBody DadosCriarTopico dados) {
        var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        var topico = new Topico(dados, usuario);
        topicoRepository.save(topico);
    }

    @GetMapping
    public List<DadosListagemTopicos> listar() {
        var topicos = topicoRepository.findAll().stream()
                .map(DadosListagemTopicos::new).toList();
        return topicos;
    }
}
