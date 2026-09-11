package com.example.greenevents.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandartError> handleValidationExceptions(MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        String errorMessage = ex.getBindingResult().getFieldError() != null
                ? ex.getBindingResult().getFieldError().getField() + " "
                        + ex.getBindingResult().getFieldError().getDefaultMessage()
                : "Erro de validação";

        StandartError err = new StandartError(
                Instant.now(),
                status.value(),
                "Validation exception",
                errorMessage,
                request.getRequestURI()

        );
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<StandartError> handlerResourceNotFound(ResourceNotFoundException ex,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError err = new StandartError(
                Instant.now(),
                status.value(),
                "Resource not found",
                ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }

}
