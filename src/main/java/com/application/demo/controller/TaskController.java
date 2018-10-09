package com.application.demo.controller;

import com.application.demo.Entity.Task;
import com.application.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET,value="/all")
    public ResponseEntity<List<Task>> getTasks() {

        return new ResponseEntity<List<Task>>(taskService.getAllTasks(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity<Void> addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Task> viewTask(@PathVariable("id") int id) {

        return new ResponseEntity<Task>(taskService.getTaskById(id),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable("id") String id, @RequestBody Task task) {

        taskService.updateTask(task);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") int id) {

        taskService.deleteTask(id);
        return new ResponseEntity<String>("Task Deleted",HttpStatus.OK);
    }
}
