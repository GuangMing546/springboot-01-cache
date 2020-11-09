package com.gm.cache.service;

import com.gm.cache.bean.Employee;
import com.gm.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * key = "#root.methodName+'['+#id+']'"
     *,keyGenerator = "mykeyGenerator",condition = "#id>1",unless = "#a0==2"
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp") //默认是用第一个参数来作为key
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }

    @CachePut(value = "emp",key = "#employee.id")   //key="#result.id"
    public Employee updateEmp(Employee employee){
        employeeMapper.update(employee);
        return employee;
    }

    //还有一个属性是allEntries = false 默认是false，设为true时是直接把缓存组件里面的所有缓存都清空，也不用你写啥key了，直接清空
    //还有一个属性是beforeInvocation = false ，默认是false，设为true是让删除缓存的操作在方法之前就执行，无论你方法中途有没有异常
    @CacheEvict(value = "emp",key = "#id")
    public void deleteEmp(Integer id){
        System.out.println("deleteEmp"+id);
//        int i=10/0;
    }

    //复杂的Caching缓存
    @Caching(
            cacheable = {
                    @Cacheable(value = "emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }

    public int insertEmp(Employee employee){
        int i = employeeMapper.insertEmp(employee);
        System.out.println("插入成功.....");
        return i;
    }
}
