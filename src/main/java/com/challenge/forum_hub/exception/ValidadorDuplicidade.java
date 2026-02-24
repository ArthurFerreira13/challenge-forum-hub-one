package com.challenge.forum_hub.exception;

import com.challenge.forum_hub.dto.DadosCadastroTopico;
import com.challenge.forum_hub.repository.TopicoRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDuplicidade implements ValidadorDeTopicos  {

        private final TopicoRepository repository;

    public ValidadorDuplicidade(TopicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validar(DadosCadastroTopico dados) {
        if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            throw new ValidacaoException("Tópico duplicado identificado!");
        }
    }
}
