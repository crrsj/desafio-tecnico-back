package br.com.projetos.components;

import br.com.projetos.dto.ProjectDTO;
import br.com.projetos.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class UpdateProjects {
    public void updatingProjects(Project project, ProjectDTO projectDTO){
     if(projectDTO.getName() != null && !projectDTO.getName().isEmpty()){
         project.setName(projectDTO.getName());
     }
      if (projectDTO.getStartDate() != null ){
         project.setStartDate(projectDTO.getStartDate());
       }
        if (projectDTO.getEndDate() != null ){
            project.setEndDate(projectDTO.getEndDate());
        }

    }


}
