package com.study.springboot.cache.service;

import com.study.springboot.cache.entity.Department;
import com.study.springboot.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@CacheConfig(cacheManager = "deptRedisCacheManager")
@Service
public class DepartmentService {



    @Autowired
    DepartmentMapper departmentMapper;

    //添加
    public void insert (Department department) {
        departmentMapper.insert(department);
    }
    //删除指定的部门
    public void delete (Integer id) {
        departmentMapper.delete(id);
    }
    //修改
    public void modify(Department department) {
        departmentMapper.modify(department);
    }
    //查询指定部门
    @Cacheable(value = {"dept"},key = "#a0",condition = "#id==2")
    public Department select(Integer id){
        return departmentMapper.getById(id);
    }


}
