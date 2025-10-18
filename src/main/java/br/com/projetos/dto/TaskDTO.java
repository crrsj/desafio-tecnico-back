package br.com.projetos.dto;

import br.com.projetos.entity.Project;
import br.com.projetos.enums.Priority;
import br.com.projetos.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class TaskDTO {
    private UUID id;
    @NotBlank(message = "cannot be empity")
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private Date dueDate;
    private Project project;
}
