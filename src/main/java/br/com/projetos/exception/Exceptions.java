package br.com.projetos.exception;

import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exceptions {

    @ExceptionHandler(ProjectNotFound.class)
    public ResponseEntity<MessageError>projectNotFound(){
    var msg = new MessageError(HttpStatus.BAD_REQUEST,"Project not found !");
    return ResponseEntity.badRequest().body(msg);
    }

    @ExceptionHandler(TaskNotFound.class)
    public ResponseEntity<MessageError>taskNotFpund(){
        var msg = new MessageError(HttpStatus.BAD_REQUEST,"Task not found !");
        return ResponseEntity.badRequest().body(msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>ValidateFields(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(Validate::new).toList());
    }

}
