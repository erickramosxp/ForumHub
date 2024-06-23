package com.alura.forumbhub.domain.resposta;

import com.alura.forumbhub.domain.topico.Topico;
import com.alura.forumbhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "respostas")
@Entity(name = "Resposta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Resposta(DadosRegistoResposta dados, Usuario usuario) {
        this.mensagem = dados.mensagem();
        this.data = LocalDateTime.now();
        this.usuario = usuario;
    }

}
