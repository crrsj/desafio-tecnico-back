package br.com.projetos.exception;

import org.springframework.http.HttpStatus;

public record MessageError(HttpStatus status, String message) {
}
