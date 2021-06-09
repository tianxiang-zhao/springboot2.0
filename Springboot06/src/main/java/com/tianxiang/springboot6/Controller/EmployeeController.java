package com.tianxiang.springboot6.Controller;

import com.tianxiang.springboot6.Dao.Person;
import com.tianxiang.springboot6.Service.APIEmployeeService;
import com.tianxiang.springboot6.Service.EmployeeService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController//组合注解 @ResponseBody + @Controller
public class EmployeeController {
    @Autowired
    EmployeeService apiEmployeeService;
    /**
     * 查询
     */
    @GetMapping("/get/{id}")
    public Person findById(@PathVariable("id") Integer id){//将传递过来的参数赋值给id
        Person byId = apiEmployeeService.findById(id);
        return byId;
    }


 /**
  *
  */
 @GetMapping("/update/{id}/{name}")
 public Person updateEmployee(@PathVariable("id") int id,@PathVariable("name") String name){
     Person person1=apiEmployeeService.findById(id);
     person1.setLast_name(name);
     Person person = apiEmployeeService.updateEmployee(person1);
     return person;
 }
/**
 * 删除
 */
@GetMapping("/delete/{id}")
public void deleteById(@PathVariable("id") Integer id){
    apiEmployeeService.deleteEmployee(id);

}



}
