package com.example.demo.service;

import com.example.demo.entity.Person;

public interface PersonService {

    int deleteByPrimaryKey(String uuid);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}
