package com.example.demo.service.impl;

import com.example.demo.Util.BasicTools;
import com.example.demo.dao.FixOrderMapper;
import com.example.demo.entity.FixOrder;
import com.example.demo.service.FixOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "FixOrdeService")
public class FixOrderServiceImpl implements FixOrderService {
    @Resource
    private FixOrderMapper fixOrderMapper;
    @Resource
    private BasicTools basicTools;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return 0;
    }

    @Override
    public int insert(FixOrder record) {
        return fixOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(FixOrder record) {
        return 0;
    }

    @Override
    public FixOrder selectByPrimaryKey(String uuid) {
        return fixOrderMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public List<FixOrder> selectAll() {
        return fixOrderMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(FixOrder record) {
        return fixOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FixOrder record) {
        return 0;
    }
}
