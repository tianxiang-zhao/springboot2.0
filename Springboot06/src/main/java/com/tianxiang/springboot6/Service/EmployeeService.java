package com.tianxiang.springboot6.Service;

import com.tianxiang.springboot6.Dao.Person;
import com.tianxiang.springboot6.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@Service
public class EmployeeService {
     @Autowired
     private PersonRepository personRepository;

    /**
     * 查询：根据Id查询 使用接口已有的方法
     */
    @Cacheable(cacheNames = "employee",unless = "#result==null")//将缓存 存放至 名为employee的名称空间中 对应缓存的唯一标识主键 k为查询的参数id
    //unless = "#result==null" 当返回值为空时 不进行存储。
    public Person findById(Integer id){
        Optional<Person> byId=personRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        else{
            return null;
        }
    }

    /**
     * 更新操作  使用自定义的方法
     * @param person
     * @return
     */
    @CachePut(cacheNames = "employee",key = "#result.id")//需要设置key值 为返回值 缓存更新
    public Person updateEmployee(Person person){
         int i=personRepository.updateEmployee(person.getLast_name(),person.getId());
        Optional<Person> byId2 = personRepository.findById(i);
        if (byId2.isPresent()){
            return byId2.get();
        }
        else{
            return null;
        }
    }


    /**
     * 删除 使用接口自带的方法
     */
    @CacheEvict(cacheNames = "employee")//缓存删除。
        public void deleteEmployee(Integer id){
            personRepository.deleteById(id);
        }


}
