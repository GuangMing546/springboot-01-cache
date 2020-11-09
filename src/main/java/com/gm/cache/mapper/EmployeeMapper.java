package com.gm.cache.mapper;

import com.gm.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Select("select * from employee where lastName=#{lastName}")
    public Employee getEmpByLastName(String lastName);

    @Insert("insert into employee (lastName,email,gender,d_id) values (#{lastName},#{email},#{gender},#{dId})")
    public int insertEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    public int deleteEmp(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public int update(Employee employee);

}
