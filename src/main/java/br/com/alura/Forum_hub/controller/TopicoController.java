package br.com.alura.Forum_hub.controller;

import br.com.alura.Forum_hub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<DadosListagemTopicos> listarTopicos(){
        return topicoRespository.findAll().stream().map(DadosListagemTopicos::new).toList();
    }
}
