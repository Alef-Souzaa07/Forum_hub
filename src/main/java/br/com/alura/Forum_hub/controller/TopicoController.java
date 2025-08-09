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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRespository topicoRespository;

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public void registrarTopico(@RequestBody @Valid DadosRegistroTopico dados){
        topicoService.registrarTopico(dados);
    }

    @GetMapping
    public Page<DadosListagemTopicos> listarTopicos(Pageable paginacao) {
        Pageable pageableOrdenado = PageRequest.of(
                paginacao.getPageNumber(),
                10,
                //paginacao.getPageSize(),
                Sort.by("data").ascending()
        );

        return topicoRespository.findAll(pageableOrdenado)
                .map(DadosListagemTopicos::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalharTopico(@PathVariable Long id) {
        var topico = topicoRespository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tópico com ID " + id + " não encontrado"
                ));

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }


    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> atualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid DadosAtualizacaoTopico dados) {

        var topicoAtualizado = topicoService.atualizarTopico(id, dados);
        return ResponseEntity.ok(topicoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirTopico(@PathVariable Long id) {
        var topico = topicoRespository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tópico com ID " + id + " não encontrado"
                ));

        topicoRespository.delete(topico);

        return ResponseEntity.noContent().build(); // HTTP 204 (sem corpo)
    }



}
