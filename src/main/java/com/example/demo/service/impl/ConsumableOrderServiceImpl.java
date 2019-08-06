package com.example.demo.service.impl;

import com.example.demo.Util.BasicTools;
import com.example.demo.dao.ConsumableOrderMapper;
import com.example.demo.entity.ConsumableOrder;
import com.example.demo.service.ConsumableOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "ConsumableOrdeService")
public class ConsumableOrderServiceImpl implements ConsumableOrderService {
    @Resource
    private ConsumableOrderMapper consumableOrderMapper;
    @Resource
    private BasicTools basicTools;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return 0;
    }

    @Override
    public int insert(ConsumableOrder record) {
        return consumableOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(ConsumableOrder record) {
        return 0;
    }

    @Override
    public ConsumableOrder selectByPrimaryKey(String uuid) {
        return consumableOrderMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public List<ConsumableOrder> selectAll() {
        return consumableOrderMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(ConsumableOrder record) {
        return consumableOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ConsumableOrder record) {
        return 0;
    }
}
