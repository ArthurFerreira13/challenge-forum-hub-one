package com.challenge.forum_hub.dto;

import com.challenge.forum_hub.entity.Usuario;

public record DadosListagemUsuario(
        Long id,
        String nome,
        String email
) {
    public DadosListagemUsuario(Usuario usuario) {
            this(usuario.getId(), usuario.getNome(), usuario.getEmail());
        }
}
