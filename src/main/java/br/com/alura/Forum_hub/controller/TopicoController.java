package br.com.alura.Forum_hub.controller;

import br.com.alura.Forum_hub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public List<DadosDetalhamentoTopico> detalharTopico(@PathVariable Long id){

    }

}
