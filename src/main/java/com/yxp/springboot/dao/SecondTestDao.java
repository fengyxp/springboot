package com.yxp.springboot.dao;


import com.yxp.springboot.bean.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SecondTestDao {
    public void insert(Question q);
    public void update(Question q);
    public void delete(Integer questionId);
    public void deleteAll();
    public Question selectOne(Integer questionId);
    public List<Question> selectAll();
}
