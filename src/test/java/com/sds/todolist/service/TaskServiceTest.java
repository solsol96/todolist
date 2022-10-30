package com.sds.todolist.service;

import com.sds.todolist.domain.Task;
import com.sds.todolist.repository.SpringDataJpaTaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class TaskServiceTest {
    @Autowired
    SpringDataJpaTaskRepository springDataJpaTaskRepository;
    @Test
    void join() {
        Task task = new Task();
        task.setOwner("james");
        springDataJpaTaskRepository.save(task);

        springDataJpaTaskRepository.findAll();
    }

}