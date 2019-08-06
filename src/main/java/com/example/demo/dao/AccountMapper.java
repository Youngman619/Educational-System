package com.example.demo.dao;

import com.example.demo.entity.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbggenerated
     */
    int insert(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbggenerated
     */
    int insertSelective(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbggenerated
     */
    Account selectByPrimaryKey(String uuid);

    Account isExist(@Param("account") String account, @Param("password") String password);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_account
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Account record);
}