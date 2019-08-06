package com.example.demo.service;

import com.example.demo.entity.Account;

public interface AccountService {

    int deleteByPrimaryKey(String uuid);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(String uuid);

    boolean isExist(String account, String password);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}
