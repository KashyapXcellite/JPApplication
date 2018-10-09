package com.application.demo.repository;

import com.application.demo.Entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    public List<Task> findByDescriptionAndTargetDate(String description, Date date);

}
