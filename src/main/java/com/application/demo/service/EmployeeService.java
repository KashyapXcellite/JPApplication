package com.application.demo.service;

import com.application.demo.Entity.Employee;
import com.application.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employees;

    public List<Employee> getEmployeeByTask(int eid) {
        List<Employee> list = new ArrayList<>();
        employees.findByTasksId(eid).forEach(e -> list.add(e));
        return list;
    }

    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        employees.findAll().forEach(e -> list.add(e));
        return list;
    }

    public Employee getEmployeeById(int empId) {
        Employee obj = employees.findById(empId).get();
        return obj;
    }

    public boolean addEmployee(Employee emp) {
        employees.save(emp);
        return true;
    }

    public void updateEmployee(Employee emp) {
        employees.save(emp);
    }

    public void deleteEmployee(int empId) {
        employees.delete(getEmployeeById(empId));
    }
}
