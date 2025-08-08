package br.com.alura.Forum_hub.controller;

import br.com.alura.Forum_hub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public void registrarTopico(@RequestBody @Valid DadosRegistroTopico dados){
        topicoService.registrarTopico(dados);
    }

    @GetMapping
    public List<DadosListagemTopicos> listarTopicos(){

    }
}
