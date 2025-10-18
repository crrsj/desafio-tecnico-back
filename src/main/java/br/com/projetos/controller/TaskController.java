package br.com.projetos.controller;

import br.com.projetos.dto.TaskDTO;
import br.com.projetos.entity.Task;
import br.com.projetos.service.TaskService;
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
@RequestMapping("/tasks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("{projectId}")
    @Operation(summary = "endpoint responsible for task registration.")
    @ApiResponse(responseCode = "201", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<TaskDTO>saveTask(@PathVariable UUID projectId, @Valid @RequestBody TaskDTO taskDTO){
        var save = taskService.saveTask(projectId,taskDTO);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @GetMapping
    @Operation(summary = "endpoint responsible listing tasks.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Page<TaskDTO>>listTasks(  @PageableDefault(page = 0, size = 10, sort = "id",
                                                     direction = Sort.Direction.ASC)
                                                     Pageable pageable){
        return ResponseEntity.ok(taskService.listTasks(pageable));

    }

    @GetMapping("/{id}")
    @Operation(summary = "endpoint responsible for searching for tasks by ID.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<TaskDTO>findById(@PathVariable UUID id){
        return ResponseEntity.ok(taskService.findById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "endpoint responsible for updating tasks by ID.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<TaskDTO>updateTask(@PathVariable UUID id, @RequestBody TaskDTO taskDTO){
        return ResponseEntity.ok(taskService.updateTask(id,taskDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "endpoint responsible for deleting tasks by ID.")
    @ApiResponse(responseCode = "204", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>deleteTask(@PathVariable UUID id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
