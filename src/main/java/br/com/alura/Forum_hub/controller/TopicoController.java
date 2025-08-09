package br.com.alura.Forum_hub.controller;

import br.com.alura.Forum_hub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    // GET
    @GetMapping
    public ResponseEntity<List<Topico>> listarTodos() {
        List<Topico> topicos = service.listarTodos();
        return ResponseEntity.ok(topicos);
    }

    // GET PARA DETALHAR
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalhar(@PathVariable Long id) {
        DadosDetalhamentoTopico detalhes = service.DetalharTopico(id);
        return ResponseEntity.ok(detalhes);
    }



    //POST
    @PostMapping
    public ResponseEntity<Topico> criar(@RequestBody @Valid DadosRegistroTopico dados) {
        Topico topicoCriado = service.criarTopico(dados);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(topicoCriado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(topicoCriado);
    }


    // PUT /topicos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Topico> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        Topico topicoAtualizado = service.atualizarTopico(id, dados);
        return ResponseEntity.ok(topicoAtualizado);
    }

    // DELETE /topicos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarTopico(id);
        return ResponseEntity.noContent().build();
    }
}

