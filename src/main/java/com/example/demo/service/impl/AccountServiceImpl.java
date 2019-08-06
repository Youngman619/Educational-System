package com.example.demo.service.impl;

import com.example.demo.Util.BasicTools;
import com.example.demo.dao.AccountMapper;
import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;
    @Resource
    private BasicTools basicTools;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return 0;
    }

    @Override
    public int insert(Account record) {
        record.setUuid(basicTools.UUID());
        return accountMapper.insert(record);
    }

    @Override
    public int insertSelective(Account record) {
        return 0;
    }

    @Override
    public Account selectByPrimaryKey(String uuid) {
        return null;
    }

    @Override
    public boolean isExist(String account, String password) {
        if(!StringUtils.isEmptyOrWhitespace(account) && !StringUtils.isEmptyOrWhitespace(password)){
            Account accountModel = accountMapper.isExist(account, password);
            if(accountModel != null){
                return true;
            }
        }
        return false;
    }

    @Override
    public int updateByPrimaryKeySelective(Account record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Account record) {
        return 0;
    }
}
