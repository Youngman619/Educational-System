package com.example.demo.service.impl;

import com.example.demo.Util.BasicTools;
import com.example.demo.dao.LessonMapper;
import com.example.demo.entity.Lesson;
import com.example.demo.service.LessonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "LessonService")
public class LessonServiceImpl implements LessonService {

    @Resource
    private LessonMapper lessonMapper;
    @Resource
    private BasicTools basicTools;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return 0;
    }

    @Override
    public int insert(Lesson record) {
        return lessonMapper.insert(record);
    }

    @Override
    public int insertSelective(Lesson record) {
        return 0;
    }

    @Override
    public Lesson selectByPrimaryKey(String uuid) {
        return lessonMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public List<Lesson> selectAll() {
        return lessonMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(Lesson record) {
        return lessonMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Lesson record) {
        return lessonMapper.updateByPrimaryKey(record);
    }
}
