package br.com.projetos.exception;

public class TaskNotFound extends RuntimeException {
    public TaskNotFound(String message) {
    }

    public TaskNotFound(){
        super();
    }
}
