package com.application.demo.service;

import com.application.demo.Entity.Task;
import com.application.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository tasks;


    public List<Task> getAllTasks() {
        List<Task> list = new ArrayList<>();
        tasks.findAll().forEach(e -> list.add(e));
        return list;
    }

    public Task getTaskById(int taskId) {
        Task obj = tasks.findById(taskId).get();
        return obj;
    }

    public void addTask(Task task) {
            tasks.save(task);
    }

    public void updateTask(Task task) {
        tasks.save(task);
    }

    public void deleteTask(int taskId) {
        tasks.delete(getTaskById(taskId));
    }
}
