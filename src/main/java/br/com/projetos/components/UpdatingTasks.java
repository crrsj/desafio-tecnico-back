package br.com.projetos.components;

import br.com.projetos.dto.TaskDTO;
import br.com.projetos.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class UpdatingTasks {

    public void uptateTasks(Task task, TaskDTO taskDTO){
        if(task.getTitle() != null && !task.getTitle().isEmpty()){
            task.setTitle(taskDTO.getTitle());
        }

        if(task.getDescription() != null && !task.getDescription().isEmpty()){
            task.setDescription(taskDTO.getDescription());
        }

        if(task.getPriority() != null){
            task.setPriority(taskDTO.getPriority());
        }
        if (task.getStatus() != null){
            task.setStatus(taskDTO.getStatus());
        }
        if(task.getDueDate() != null){
            task.setDueDate(taskDTO.getDueDate());
        }
    }
}
