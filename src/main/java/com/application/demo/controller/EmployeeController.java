package com.application.demo.controller;

import com.application.demo.Entity.Employee;
import com.application.demo.Entity.Task;
import com.application.demo.service.EmployeeService;
import com.application.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TaskService taskService;

    @GetMapping("task/{tid}")
    public ResponseEntity<List<Employee>> getTaskEmployee(@PathVariable("tid") int tid) {
        List<Employee> emps = employeeService.getEmployeeByTask(tid);
        return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.POST,value = "/")
//    public ResponseEntity<Employee> addEmployeelost(@RequestBody Employee employee) {
//        Boolean added = employeeService.addEmployee(employee);
//        if (added) {
//            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
//        }
//        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/task/{taskId}")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee, @PathVariable("taskId") int taskId) {
        Set<Task> employeeTasks=new HashSet<>();
        employeeTasks.add(taskService.getTaskById(taskId));
        employee.setTasks(employeeTasks);
        employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}/task/{taskId}")
    public void updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee, @PathVariable("taskId") int taskId) {
        Set<Task> employeeTasks=new HashSet<>();
        employeeTasks.add(taskService.getTaskById(taskId));
        employee.setTasks(employeeTasks);
        employeeService.updateEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{empId}/task/{taskId}")
    public void deleteEmployee(@PathVariable("empId") int empId) {

        employeeService.deleteEmployee(empId);
    }
}
