package com.tianxiang.springboot6.Service;


import com.tianxiang.springboot6.Dao.Person;
import com.tianxiang.springboot6.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class APIEmployeeService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RedisTemplate redisTemplate;//注入redisTemplate  从缓存中查找数据


    /**
     * 查询方法
     */
    public Person findById(Integer id){
        Object o = redisTemplate.opsForValue().get("employee_" + id);
        if (o!=null){
            return (Person)o;
        }
        else {
            Optional<Person> byId = personRepository.findById(id);
            if (byId.isPresent()){
                Person person = byId.get();
                redisTemplate.opsForValue().set("employee_"+id,person, 1,TimeUnit.DAYS);//设置redis缓存的key值 value值 存活时间 为1 天
                return byId.get();
            }
            return null;
        }

    }

    /**
     * 跟新
     */
    public Person updatePerson(Person person){
        int i = personRepository.updateEmployee(person.getLast_name(), person.getId());
        redisTemplate.opsForValue().set("employee_"+person.getId(),person);
        return person;
    }

    /**
     * 删除方法
     */
    public void deletePerson(Integer id){
        personRepository.deleteById(id);
        redisTemplate.delete("employee_"+id);
    }
}
