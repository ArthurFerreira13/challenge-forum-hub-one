package com.challenge.forum_hub.controller;

import com.challenge.forum_hub.dto.DadosCadastroTopico;
import com.challenge.forum_hub.dto.DadosListagemTopico;
import com.challenge.forum_hub.entity.Topico;
import com.challenge.forum_hub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
        var topico = service.cadastrar(dados);
        return ResponseEntity.ok(topico);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemTopico>> listar() {
        var lista = service.listar();
        return ResponseEntity.ok(lista);
    }
}