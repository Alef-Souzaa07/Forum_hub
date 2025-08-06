package br.com.alura.Forum_hub.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@NoArgsConstructor      // necessário para o JPA
@AllArgsConstructor     // útil para testes, DTOs ou criação manual
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;

    public Curso(DadosDoCurso dados) {

    }
}
