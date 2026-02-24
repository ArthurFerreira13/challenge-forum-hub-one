package com.challenge.forum_hub.controller;

import com.challenge.forum_hub.dto.DadosAtualizacaoUsuario;
import com.challenge.forum_hub.dto.DadosCadastroUsuario;
import com.challenge.forum_hub.dto.DadosListagemUsuario;
import com.challenge.forum_hub.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired // Você pode usar injeção via campo ou manter o construtor que já tinha
    private UsuarioService service;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
        var dto = service.cadastrar(dados);

        // Boas práticas: Retornar 201 Created e o cabeçalho Location
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemUsuario>> listar() {
        var lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}") // Novo método PUT
    @Transactional // Garante que a alteração seja commitada no banco
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoUsuario dados) {
        var usuarioAtualizado = service.atualizar(id, dados);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }

}
