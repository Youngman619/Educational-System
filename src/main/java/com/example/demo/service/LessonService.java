package com.example.demo.service;

import com.example.demo.entity.Lesson;

import java.util.List;

public interface LessonService {
    int deleteByPrimaryKey(String uuid);

    int insert(Lesson record);

    int insertSelective(Lesson record);

    Lesson selectByPrimaryKey(String uuid);

    List<Lesson> selectAll();

    int updateByPrimaryKeySelective(Lesson record);

    int updateByPrimaryKey(Lesson record);
}
