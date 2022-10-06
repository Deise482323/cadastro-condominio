package com.cadastroCondominio.config;

import com.cadastroCondominio.exeption.CondominioNaoEncontradoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@RestController
@ControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CondominioNaoEncontradoException.class)
    public ResponseEntity<DefaultError> condominioNaoEncontradoException() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(DefaultError
                        .builder()
                        .msg("morador não encontrado")
                        .build());
    }
}
