package br.com.alura.Forum_hub.error;

import br.com.alura.Forum_hub.error.excecoes.RegistroDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TratadorDeExcecoes {

    @ExceptionHandler(RegistroDuplicadoException.class)
    public ResponseEntity<String> handleRegistroDuplicadoException(RegistroDuplicadoException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

}

