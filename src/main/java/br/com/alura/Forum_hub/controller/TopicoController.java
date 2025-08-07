package br.com.alura.Forum_hub.controller;

import br.com.alura.Forum_hub.domain.topico.DadosRegistroTopico;
import br.com.alura.Forum_hub.domain.topico.Topico;
import br.com.alura.Forum_hub.domain.topico.TopicoRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRespository respository;

    @PostMapping
    public void RegistrarTopico(@RequestBody DadosRegistroTopico dados){
        respository.save(new Topico(dados));
    }
}
