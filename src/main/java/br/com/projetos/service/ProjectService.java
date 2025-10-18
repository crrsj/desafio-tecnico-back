package br.com.projetos.service;

import br.com.projetos.components.Converter;
import br.com.projetos.components.UpdateProjects;
import br.com.projetos.dto.ProjectDTO;
import br.com.projetos.exception.ProjectNotFound;
import br.com.projetos.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final Converter converter;
    private final UpdateProjects updateProjects;


    public ProjectDTO saveProject(ProjectDTO projectDTO){
        var project = converter.dtoToEntity(projectDTO);
        var savedProject = projectRepository.save(project);
        return converter.entityToDto(savedProject);

    }

    public Page<ProjectDTO> listProjects(Pageable pageable){
        return projectRepository.findAll(pageable).map( converter::entityToDto);
    }

    public ProjectDTO findById(UUID id){
        var find = projectRepository.findById(id).orElseThrow(ProjectNotFound::new );
        return converter.entityToDto(find);
    }

    public ProjectDTO update(UUID id, ProjectDTO projectDTO){
        var updating = projectRepository.findById(id).orElseThrow(ProjectNotFound::new );
        updateProjects.updatingProjects(updating,projectDTO);
        var updated = projectRepository.save(updating);
        return converter.entityToDto(updated);
    }
    public void deleteProject(UUID id){
        if (projectRepository.existsById(id)){
            projectRepository.deleteById(id);
        }else {
            throw new  ProjectNotFound("Project not found !");
        }
    }
}
