package com.example.demo.service.impl;

import com.example.demo.Util.BasicTools;
import com.example.demo.dao.TeacherMapper;
import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "TeacherService")
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private BasicTools basicTools;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return 0;
    }

    @Override
    public int insert(Teacher record) {
        record.setEntrytime(basicTools.currentTimestamp());
        record.setStatus("1");
        return teacherMapper.insert(record);
    }

    @Override
    public int insertSelective(Teacher record) {
        return 0;
    }

    @Override
    public Teacher selectByPrimaryKey(String uuid) {
        return teacherMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public List<Teacher> selectAll() {
        return teacherMapper.selectAll();
    }

    @Override
    public Teacher selectByTeacherId(String teacherId) {
        return teacherMapper.selectByTeacherId(teacherId);
    }

    @Override
    public int updateByPrimaryKeySelective(Teacher record) {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Teacher record) {
        return teacherMapper.updateByPrimaryKey(record);
    }
}
