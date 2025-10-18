package br.com.projetos.controller;

import br.com.projetos.dto.ProjectDTO;
import br.com.projetos.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    @Operation(summary = "endpoint responsible for project registration.")
    @ApiResponse(responseCode = "201", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })

    public ResponseEntity<ProjectDTO>saveProject(@RequestBody @Valid ProjectDTO projectDTO){
        var save = projectService.saveProject(projectDTO);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @GetMapping
    @Operation(summary = "endpoint responsible for listing projects.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Page<ProjectDTO>> listProjects(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)
            Pageable pageable) {
        return ResponseEntity.ok(projectService.listProjects(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "endpoint responsible for searching for projects by ID.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<ProjectDTO>findById(@PathVariable UUID id){
        return ResponseEntity.ok(projectService.findById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "endpoint responsible update project by ID.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<ProjectDTO>updateProjects(@PathVariable UUID id, @RequestBody ProjectDTO projectDTO){
        return ResponseEntity.ok(projectService.update(id,projectDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "endpoint responsible for deleting for projects by ID.")
    @ApiResponse(responseCode = "204", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>deleteProject(@PathVariable UUID id){
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
