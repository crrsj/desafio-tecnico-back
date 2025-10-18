package br.com.projetos.components;

import br.com.projetos.dto.TaskDTO;
import br.com.projetos.entity.Project;
import br.com.projetos.dto.ProjectDTO;

import br.com.projetos.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public Project dtoToEntity(ProjectDTO projectDTO){
        var project = new Project();
        project.setId(projectDTO.getId());
        project.setName(projectDTO.getName());
        project.setStartDate(projectDTO.getStartDate());
        project.setEndDate(projectDTO.getEndDate());
        return  project;
    }

    public ProjectDTO entityToDto(Project project){
        var projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setStartDate(project.getStartDate());
        projectDTO.setEndDate(project.getEndDate());
        return projectDTO;

    }

    public Task taskDtoToEntity(TaskDTO taskDTO){
        var task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setPriority(taskDTO.getPriority());
        task.setDueDate(taskDTO.getDueDate());
        task.setProject(taskDTO.getProject());
        return task;
    }

    public TaskDTO taskEntityToDto(Task task){
        var taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setPriority(task.getPriority());
        taskDTO.setDueDate(task.getDueDate());
        taskDTO.setProject(task.getProject());
        return taskDTO;
    }
}