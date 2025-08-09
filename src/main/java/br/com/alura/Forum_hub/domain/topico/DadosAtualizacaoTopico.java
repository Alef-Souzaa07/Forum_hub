package br.com.alura.Forum_hub.domain.topico;

import br.com.alura.Forum_hub.domain.curso.Curso;

public record DadosAtualizacaoTopico(String titulo, String mensagem, EstadoTopico status, String autor, Curso curso) {
}
