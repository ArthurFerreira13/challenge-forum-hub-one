package com.challenge.forum_hub.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopico(
        @NotBlank (message = "O título não pode ser vazio")
        String titulo,
        @NotBlank ( message = "A mensagem não pode ser vazia")
        String mensagem,
        @NotBlank (message = "O autor não pode ser vazio")
        String autor,
        @NotBlank (message = "O curso não pode ser vazio")
        String curso
) {
}
