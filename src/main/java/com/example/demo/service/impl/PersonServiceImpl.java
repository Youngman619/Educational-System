package com.example.demo.service.impl;

import com.example.demo.Util.BasicTools;
import com.example.demo.dao.PersonMapper;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;

@Service(value = "personService")
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;
    @Resource
    private BasicTools basicTools;


    @Override
    public int deleteByPrimaryKey(String uuid) {
        return 0;
    }

    @Override
    public int insert(Person record) {
        record.setInserttime(basicTools.currentTimestamp());
        record.setLastmodifytime(basicTools.currentTimestamp());
        return personMapper.insert(record);
    }

    @Override
    public int insertSelective(Person record) {
        return 0;
    }

    @Override
    public Person selectByPrimaryKey(String uuid) {
        if(!StringUtils.isEmptyOrWhitespace(uuid)){
            return personMapper.selectByPrimaryKey(uuid);
        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Person record) {
        return personMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Person record) {
        return personMapper.updateByPrimaryKey(record);
    }
}
