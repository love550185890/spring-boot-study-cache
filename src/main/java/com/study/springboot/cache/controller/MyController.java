package com.study.springboot.cache.controller;

import com.study.springboot.cache.entity.Department;
import com.study.springboot.cache.entity.Employee;
import com.study.springboot.cache.mapper.DepartmentMapper;
import com.study.springboot.cache.service.DepartmentService;
import com.study.springboot.cache.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    //查询指定部门
    @ResponseBody
    @GetMapping("/dept/{id}")
    public Department selectById(@PathVariable("id") Integer id) {
        logger.info("----/dept/id---selectById----");
        return departmentService.select(id);
    }

    //修改
    @ResponseBody
    @GetMapping("/modify")
    public String modify(Department department) {
        logger.info("modify before------>"+department);
        departmentService.modify(department);
        return "修改成功";
    }

    //添加
    @ResponseBody
    @GetMapping("/insert")
    public String insert(Department department){
            logger.info("insert------->"+department);
        departmentService.insert(department);
        return "插入成功";
    }

    //
    @ResponseBody
    @GetMapping("/delDept/{id}")
    public String delete (@PathVariable("id") Integer id) {
        departmentService.delete(id);
        return "删除成功";
    }


    //查询某一个员工
    @ResponseBody
    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        return employeeService.getById(id);
    }
}
