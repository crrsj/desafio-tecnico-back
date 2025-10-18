package br.com.projetos.exception;

public class ProjectNotFound extends RuntimeException{
    public ProjectNotFound(String message) {
        super(message);
    }

    public ProjectNotFound(){
        super();
    }
}
