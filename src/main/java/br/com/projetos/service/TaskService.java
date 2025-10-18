package br.com.projetos.service;

import br.com.projetos.components.Converter;
import br.com.projetos.components.UpdateProjects;
import br.com.projetos.components.UpdatingTasks;
import br.com.projetos.dto.TaskDTO;
import br.com.projetos.exception.ProjectNotFound;
import br.com.projetos.exception.TaskNotFound;
import br.com.projetos.repository.ProjectRepository;
import br.com.projetos.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final Converter converter;
    private final ProjectRepository projectRepository;
    private final UpdatingTasks updatingTasks;

    public TaskDTO saveTask(UUID projectId, TaskDTO taskDTO){
    var project = projectRepository.findById(projectId).orElseThrow(()->new ProjectNotFound("Project not found !"));
    var task = converter.taskDtoToEntity(taskDTO);
    task.setProject(project);
    var taskSaved = taskRepository.save(task);
    return converter.taskEntityToDto(taskSaved);
    }

    public Page<TaskDTO>listTasks(Pageable pageable){
        return taskRepository.findAll(pageable).map(converter::taskEntityToDto);
    }

    public TaskDTO findById(UUID id){
     var find = taskRepository.findById(id).orElseThrow(TaskNotFound::new);
     return converter.taskEntityToDto(find);
    }

    public TaskDTO updateTask(UUID id, TaskDTO taskDTO){
        var updating = taskRepository.findById(id).orElseThrow(TaskNotFound::new);
        updatingTasks.uptateTasks(updating,taskDTO);
        var taskUpdate = taskRepository.save(updating);
        return converter.taskEntityToDto(taskUpdate);
    }

    public void deleteTask(UUID id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        }else {
            throw new TaskNotFound();
        }
    }
}
