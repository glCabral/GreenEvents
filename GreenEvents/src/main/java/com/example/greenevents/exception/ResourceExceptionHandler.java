package com.example.greenevents.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandartError error2 = new StandartError(
                Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error2);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandartError> validationError(MethodArgumentNotValidException e,
            HttpServletRequest request) {
        String error = "Argumento inválido";
        HttpStatus invalido = HttpStatus.BAD_REQUEST;

        String msg = e.getBindingResult().getFieldError().getDefaultMessage();
        StandartError error2 = new StandartError(Instant.now(), invalido.value(), error, msg,
                request.getRequestURI());

        return ResponseEntity.status(invalido).body(error2);
    }
}
