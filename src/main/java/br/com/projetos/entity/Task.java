package br.com.projetos.entity;

import br.com.projetos.enums.Priority;
import br.com.projetos.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Size(min = 5,max = 150)
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private Date dueDate;
    @JoinColumn(name = "projectId")
    @ManyToOne
    private Project  project;
}
