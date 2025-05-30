package mikuTest.TestRestApi.controller;

import mikuTest.TestRestApi.entity.TodoEntity;
import mikuTest.TestRestApi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todoEntity, @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todoEntity, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong!");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.completeTodo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong!");
        }
    }



}
