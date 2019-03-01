package com.study.springboot.cache.service;

import com.study.springboot.cache.entity.Employee;
import com.study.springboot.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheManager = "employeeRediscacheManager")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = "emp",key = "#id")
    public Employee getById(Integer id){
        return employeeMapper.getById(id);
    };
}
