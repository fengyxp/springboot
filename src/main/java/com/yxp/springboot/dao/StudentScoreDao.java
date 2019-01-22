package com.yxp.springboot.dao;


import com.yxp.springboot.bean.StudentScore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentScoreDao {
    public void insert(StudentScore s);
    public void update(StudentScore s);
    public void delete(String studentId);
    public StudentScore selectOne(String studentId);
    public List<StudentScore> selectAll();

}
