package com.tianxinag.springboot03.repository;

import com.tianxinag.springboot03.Beans.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person,String> {//需要传入 返回类型，和主键类型

   public List<Person> findByLastName(String lastname);
   public Page<Person> findPersonByLastName(String lastname, Pageable page);
   public List<Person> findByLastNmaeAndfirstName(String lastname,String firstname);
   public  List<Person> findByAddress_City(String city);
   public  List<Person> findByFamliyList_Username(String username);



}
