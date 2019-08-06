package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

    int deleteByPrimaryKey(String uuid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String uuid);

    List<Student> selectAll();

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
