package Geraldo.todo_api.controller;

import Geraldo.todo_api.business.TasksService;
import Geraldo.todo_api.infrastructure.entity.Tasks;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TasksController {

    private final TasksService tasksService;

    @PostMapping
    public ResponseEntity<Void> createTasks(@RequestBody Tasks tasks) {
        tasksService.createTasks(tasks);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Tasks> findTaskById(@RequestParam Integer id) {
        return ResponseEntity.ok(tasksService.searchTasksById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletTaskById(@RequestParam Integer id) {
        tasksService.deletById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateTasks(@RequestParam Integer id,
                                            @RequestBody Tasks tasks
    ) {
        tasksService.updateTasks(id, tasks);
        return ResponseEntity.ok().build();
    }

}
