package com.challenge.forum_hub.controller;

import com.challenge.forum_hub.dto.DadosCadastroTopico;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
        System.out.println("Requisição recebida com sucesso!");
        System.out.println("Conteúdo: " + dados);
    }
}
