package com.challenge.forum_hub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        Long id,
        @NotBlank (message = "O título não pode ser vazio")
        String titulo,
        @NotBlank (message = "A mensagem não pode ser vazia")
        String mensagem
) {
}
