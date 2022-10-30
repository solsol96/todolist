package com.sds.todolist.repository;


import com.sds.todolist.domain.Status;
import com.sds.todolist.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataJpaTaskRepository extends JpaRepository<Task, Long>{
    public Long countByStatusNot(Status status);
    public Long countByStatus(Status status);
    public List<Task> findAllByStatusNot(Status status);
}
