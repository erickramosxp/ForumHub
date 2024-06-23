package com.alura.forumbhub.controller;

import com.alura.forumbhub.domain.resposta.DadosRegistoResposta;
import com.alura.forumbhub.domain.resposta.Resposta;
import com.alura.forumbhub.domain.resposta.RespostasRepository;
import com.alura.forumbhub.domain.topico.TopicoRepository;
import com.alura.forumbhub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void registrarResposta(@PathVariable Long id, @RequestBody DadosRegistoResposta dados) {
        var topico = topicoRepository.getReferenceById(id);
        var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        Resposta resposta = new Resposta(dados, usuario);
        topico.addResposta(resposta);
        respostasRepository.save(resposta);
    }
}
