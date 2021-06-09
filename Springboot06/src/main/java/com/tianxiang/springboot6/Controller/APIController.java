package com.tianxiang.springboot6.Controller;


import com.tianxiang.springboot6.Dao.Person;
import com.tianxiang.springboot6.Service.APIEmployeeService;
import com.tianxiang.springboot6.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("Api")//访问时 8080后面要加上API： 127.0.0.1:8080/Api/XX
@RestController//组合注解 @ResponseBody + @Controller
public class APIController {
    @Autowired
    APIEmployeeService aPIEmployeeService;

    /**
     * 查询
     */
    @GetMapping("/get/{id}")
    public Person findById(@PathVariable("id") Integer id) {//将传递过来的参数赋值给id
        Person byId = aPIEmployeeService.findById(id);
        return byId;
    }


    /**
     *
     */
    @GetMapping("/update/{id}/{name}")
    public Person updateEmployee(@PathVariable("id") int id, @PathVariable("name") String name) {
        Person person1 = aPIEmployeeService.findById(id);
        person1.setLast_name(name);
        Person person = aPIEmployeeService.updatePerson(person1);
        return person;

    }

    /**
     * 删除
     */
    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        aPIEmployeeService.deletePerson(id);

    }
}