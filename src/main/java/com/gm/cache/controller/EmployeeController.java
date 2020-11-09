package com.gm.cache.controller;

import com.gm.cache.bean.Employee;
import com.gm.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id) {
        Employee emp = service.getEmp(id);
        return emp;
    }
//    @GetMapping("/emp")
//    public int insertEmp(Employee employee){
//        return service.insertEmp(employee);
//    }
    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        service.updateEmp(employee);
        return employee;
    }

    @GetMapping("/emp/delete/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        service.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName){
        return service.getEmpByLastName(lastName);
    }

}
