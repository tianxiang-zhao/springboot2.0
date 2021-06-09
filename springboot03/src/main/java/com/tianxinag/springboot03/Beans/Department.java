package com.tianxinag.springboot03.Beans;

import java.util.List;

public class Department {
    private Integer id;
    private String dept_name;
    private List<Employee> employees;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dept_name='" + dept_name + '\'' +
                ", employees=" + employees +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
