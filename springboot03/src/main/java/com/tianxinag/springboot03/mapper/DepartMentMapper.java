package com.tianxinag.springboot03.mapper;

import com.tianxinag.springboot03.Beans.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartMentMapper {


    //使用id查询部分。
    public Department getDepartById(Integer id);
}
