package com.tianxinag.springboot03;

import com.tianxinag.springboot03.Beans.Department;
import com.tianxinag.springboot03.Beans.Employee;
import com.tianxinag.springboot03.mapper.DepartMentMapper;
import com.tianxinag.springboot03.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot03ApplicationTests {

    @Autowired
    private  EmployeeMapper employeeMapper;

    @Autowired
    private DepartMentMapper departMentMapper;

    @Test
    void contextLoads() {
        Employee employee=employeeMapper.getEmployeeById(1);
        System.out.println(employee);
    }

    @Test
    void testDepartment() {
        Department department=departMentMapper.getDepartById(1);
        System.out.println(department);
    }

}
