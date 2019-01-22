package com.yxp.springboot.dao;


import com.yxp.springboot.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentDao {
    public void insert(Student s);
    public void update(Student s);
    public void delete(String studentId);
    public Student selectOne(String studentId);
    public List<Student> selectAll();

}
