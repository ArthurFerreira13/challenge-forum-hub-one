package com.challenge.forum_hub.controller;

import com.challenge.forum_hub.dto.DadosAtualizacaoTopico;
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

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados) {
        var dto = service.atualizar(dados);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluir(id);

        // O padrão REST para exclusão bem-sucedida é o código 204 (No Content)
        return ResponseEntity.noContent().build();
    }
}