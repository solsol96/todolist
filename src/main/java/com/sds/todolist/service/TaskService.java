package com.sds.todolist.service;

import com.sds.todolist.domain.Status;
import com.sds.todolist.domain.Task;
import com.sds.todolist.dto.TaskDto;
import com.sds.todolist.repository.SpringDataJpaTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final SpringDataJpaTaskRepository repository;

    public Long saveTask(TaskDto taskDto) {
        Task task = new Task(null, taskDto.getOwner(), taskDto.getContent(), Status.REGISTERED);
        return repository.save(task).getId();
    }

    public List<Task> getTasks() {
        return repository.findAllByStatusNot(Status.DELETED);
    }

    public Long getCountTasks() {
        return repository.countByStatusNot(Status.DELETED);
    }

    public Long getCountCompletedTasks() {
        return repository.countByStatus(Status.REGISTERED);
    }
}
