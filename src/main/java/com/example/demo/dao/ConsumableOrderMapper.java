package com.example.demo.dao;

import com.example.demo.entity.ConsumableOrder;

import java.util.List;

public interface ConsumableOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_consumable_order
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_consumable_order
     *
     * @mbggenerated
     */
    int insert(ConsumableOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_consumable_order
     *
     * @mbggenerated
     */
    int insertSelective(ConsumableOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_consumable_order
     *
     * @mbggenerated
     */
    ConsumableOrder selectByPrimaryKey(String uuid);

    List<ConsumableOrder> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_consumable_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ConsumableOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_consumable_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ConsumableOrder record);
}