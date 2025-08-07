package br.com.alura.Forum_hub.domain.topico;

import br.com.alura.Forum_hub.domain.curso.Curso;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRespository extends JpaRepository<Topico, Long> {
    Page<Topico> findByCurso(Curso curso, Pageable pageable);

    boolean existsByTituloAndMensagem(@NotBlank String titulo, @NotBlank String mensagem);
}
