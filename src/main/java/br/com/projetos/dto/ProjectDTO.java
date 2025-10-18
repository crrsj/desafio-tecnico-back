package br.com.projetos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ProjectDTO {
    private UUID id;
    @NotBlank(message = "cannot be empity")
    @Size(min = 3,max = 100,message = "the size must be between 3 and 100 carats")
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private Date endDate;
}
