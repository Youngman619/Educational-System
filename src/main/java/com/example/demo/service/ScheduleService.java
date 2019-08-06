package com.example.demo.service;

import com.example.demo.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    int deleteByPrimaryKey(String uuid);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(String uuid);

    List<Schedule> selectAll();

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
}
