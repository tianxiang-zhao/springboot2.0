package com.tianxinag.springboot03.mapper;


import com.tianxinag.springboot03.Beans.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper//表示是一个mybatis接口文件，是需要被springboot扫描的。
public interface EmployeeMapper {


    //查询方法
    @Select("select * from tbl_employee where id=#{id}")
    public Employee getEmployeeById(Integer id);

    //添加方法

    /**
     *   private Integer id;
     *     private String last_name;
     *     private String gender;
     *     private String emmail;
     *     private Integer d_id;
     */

    @Insert("insert into tbl_employee values(#{id},#{last_name},#{gender},#{emmail},#{d_id})")
    public void  insertEmployee();


}
