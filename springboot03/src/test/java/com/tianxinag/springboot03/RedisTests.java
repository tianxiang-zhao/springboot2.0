package com.tianxinag.springboot03;

import com.tianxinag.springboot03.Beans.*;
import com.tianxinag.springboot03.mapper.DepartMentMapper;
import com.tianxinag.springboot03.mapper.EmployeeMapper;
import com.tianxinag.springboot03.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RedisTests {

    @Autowired
    PersonRepository repository;



    @Test
    void savePerson() {
        Person person=new Person();

        person.setFirstname("张");
        person.setLastname("漂亮");


        Address address=new Address();
        address.setCity("北京");


        person.setAddress(address);


        Famliy famliy=new Famliy();
        famliy.setType("父亲");
        famliy.setUsername("张大大");

        Famliy famliy2=new Famliy();
        famliy.setType("母亲");
        famliy.setUsername("漂亮");

        ArrayList<Famliy> famlies=new ArrayList<>();
        famlies.add(famliy);
        famlies.add(famliy2);
        person.setFamliyList(famlies);



        repository.save(person);

    }

}
