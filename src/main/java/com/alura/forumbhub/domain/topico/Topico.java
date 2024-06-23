package com.alura.forumbhub.domain.topico;

import com.alura.forumbhub.domain.Curso;
import com.alura.forumbhub.domain.resposta.DadosRegistoResposta;
import com.alura.forumbhub.domain.resposta.Resposta;
import com.alura.forumbhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data;
    /*ABERTO, RESOLVIDO...*/
    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas;

    public Topico(DadosCriarTopico dados, Usuario usuario) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = LocalDateTime.now();
        this.status = "Aberto";
        this.usuario = usuario;
        this.curso = dados.curso();
    }

    public void addResposta(Resposta resposta) {
        resposta.setTopico(this);
        respostas.add(resposta);
    }
}
