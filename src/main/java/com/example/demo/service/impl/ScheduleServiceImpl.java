package com.example.demo.service.impl;

import com.example.demo.Util.BasicTools;
import com.example.demo.dao.ScheduleMapper;
import com.example.demo.entity.Schedule;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "ScheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleMapper scheduleMapper;
    @Resource
    private BasicTools basicTools;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return 0;
    }

    @Override
    public int insert(Schedule record) {
        return scheduleMapper.insert(record);
    }

    @Override
    public int insertSelective(Schedule record) {
        return 0;
    }

    @Override
    public Schedule selectByPrimaryKey(String uuid) {
        return scheduleMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public List<Schedule> selectAll() {
        return scheduleMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(Schedule record) {
        return scheduleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Schedule record) {
        return scheduleMapper.updateByPrimaryKey(record);
    }
}
