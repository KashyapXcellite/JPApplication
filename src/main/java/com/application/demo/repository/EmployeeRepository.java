package com.application.demo.repository;

import com.application.demo.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    public List<Employee> findByTasksId(int eid);
}
