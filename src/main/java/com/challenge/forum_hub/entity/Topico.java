package com.challenge.forum_hub.entity;

import com.challenge.forum_hub.dto.DadosCadastroTopico;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private String status = "NAO_RESPONDIDO";
    private String autor;
    private String curso;

    // Construtor essencial para converter o DTO em Entidade
    public Topico(DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();
    }
}
