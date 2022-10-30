package com.sds.todolist.controller;

import com.sds.todolist.domain.Task;
import com.sds.todolist.dto.TaskDto;
import com.sds.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class taskController {
    private final TaskService taskService;

    @PostMapping("/register")
    public ResponseEntity<Long> saveTask(@RequestBody TaskDto data) {
        System.out.println(data.getContent() + data.getOwner());
        Long aLong = taskService.saveTask(data);
        return new ResponseEntity(aLong, HttpStatus.OK);
    }

    @GetMapping("/count/tasks")
    public ResponseEntity<Long> getCountTasks() {
        return new ResponseEntity(taskService.getCountTasks(), HttpStatus.OK);
    }

    @GetMapping("/count/completed-tasks")
    public ResponseEntity<Long> getCountCompletedTasks() {
        return new ResponseEntity(taskService.getCountCompletedTasks(), HttpStatus.OK);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks() {
        return new ResponseEntity(taskService.getTasks(), HttpStatus.OK);
    }
}