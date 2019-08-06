package com.example.demo.service;

import com.example.demo.entity.ConsumableOrder;

import java.util.List;

public interface ConsumableOrderService {
    int deleteByPrimaryKey(String uuid);

    int insert(ConsumableOrder record);

    int insertSelective(ConsumableOrder record);

    ConsumableOrder selectByPrimaryKey(String uuid);

    List<ConsumableOrder> selectAll();

    int updateByPrimaryKeySelective(ConsumableOrder record);

    int updateByPrimaryKey(ConsumableOrder record);
}
