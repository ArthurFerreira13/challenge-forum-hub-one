package com.challenge.forum_hub.exception;

import com.challenge.forum_hub.dto.DadosCadastroTopico;

public interface ValidadorDeTopicos {
    void validar(DadosCadastroTopico dados);
}
