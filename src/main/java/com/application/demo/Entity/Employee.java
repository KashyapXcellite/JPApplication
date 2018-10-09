package com.application.demo.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {

    @Id
    private int id;
    private String city;
    private String name;
    private String employeeType;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Task> tasks;

    public Employee()
    {

    }

    public Employee(int id, String city, String name, String employeeType,Set<Task> tasks) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.employeeType = employeeType;
        this.tasks=tasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getemployeeType() {
        return employeeType;
    }

    public void setemployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {

        this.tasks=tasks;
    }

}
