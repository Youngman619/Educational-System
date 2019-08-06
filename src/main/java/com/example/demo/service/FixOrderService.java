package com.example.demo.service;

import com.example.demo.entity.FixOrder;

import java.util.List;

public interface FixOrderService {
    int deleteByPrimaryKey(String uuid);

    int insert(FixOrder record);

    int insertSelective(FixOrder record);

    FixOrder selectByPrimaryKey(String uuid);

    List<FixOrder> selectAll();

    int updateByPrimaryKeySelective(FixOrder record);

    int updateByPrimaryKey(FixOrder record);
}
