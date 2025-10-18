package br.com.projetos.exception;

import org.springframework.validation.FieldError;

public record Validate(String field, String message) {
    public Validate(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}
