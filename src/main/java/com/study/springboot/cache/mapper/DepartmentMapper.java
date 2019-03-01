package com.study.springboot.cache.mapper;

import com.study.springboot.cache.entity.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.Cacheable;

@Mapper
public interface DepartmentMapper {

    //添加
    @Insert("insert into department (departmentName) values(#{departmentName})")
    public void insert(Department department);

    //删除
    @Delete("delete from department where id = #{id}")
    public void delete(Integer id);

    //修改
    @Update("update department set departmentName=#{departmentName} where id = #{id}")
    public void modify(Department department);

    //查询
    @Select("select * from department where id = #{id}")
    public Department getById(Integer id);
}
