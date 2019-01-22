package com.yxp.springboot.dao;


import com.yxp.springboot.bean.StudentAnswer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentAnswerDao {
    public void insert(StudentAnswer q);

    public void update(StudentAnswer q);

    public void deleteQ(Integer questionId);

    public void deleteS(String studentId);

    public List<StudentAnswer> selectQ(Integer questionId);

    public List<StudentAnswer> selectS(String studentId);

    public List<StudentAnswer> selectAll();
}
