package com.tianxiang.springboot6.Repository;

import com.tianxiang.springboot6.Dao.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person,Integer> {  //继承一些现有的方法
    //根据id修改信息
    @Modifying//表示当前是一个更新操作。
    @Query("update tbl_employee e set e.last_name=?1 where e.id=?2")//?表示参数 1  2  表示第几个参数。
    public int updateEmployee(String person,Integer id);
}
