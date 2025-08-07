package br.com.alura.Forum_hub.controller;

import br.com.alura.Forum_hub.domain.topico.DadosRegistroTopico;
import br.com.alura.Forum_hub.domain.topico.Topico;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {


    @PostMapping
    public void RegistrarTopico(@RequestBody String json){
        System.out.println(json);
    }
}
