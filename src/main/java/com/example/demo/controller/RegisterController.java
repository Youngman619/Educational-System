package com.example.demo.controller;

import com.example.demo.Util.BasicTools;
import com.example.demo.entity.Account;
import com.example.demo.entity.Person;
import com.example.demo.service.AccountService;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private BasicTools basicTools;
    @Autowired
    private AccountService accountService;
    @Autowired
    private PersonService personService;

    @RequestMapping("/register")
    public String doView(ModelMap model){
        return "register";
    }

    @PostMapping(value = "/user/register")
    public String register(@RequestParam Map<String,Object> reqMap, HttpServletRequest request, HttpServletResponse response)throws IOException{
        String personUuid = basicTools.UUID();
        String personName = String.valueOf(reqMap.get("personName"));
        String phone = String.valueOf(reqMap.get("phone"));
        String account = String.valueOf(reqMap.get("account"));
        String password = String.valueOf(reqMap.get("password"));
        String gender = String.valueOf(reqMap.get("gender"));
        String birthday = String.valueOf(reqMap.get("birthday"));
        String role = String.valueOf(reqMap.get("role"));

        Person personModel = new Person();
        personModel.setUuid(personUuid);
        personModel.setPersonname(personName);
        personModel.setPhone(phone);
        personModel.setGender(gender);
        personModel.setBirthday(birthday);
        personModel.setRole(role);

        boolean isExist = accountService.isExist(account, password);
        if(isExist){
            return "login";
        }else{
            Account accountModel = new Account();
            accountModel.setPersonuuid(personUuid);
            accountModel.setAccount(account);
            accountModel.setPassword(password);
            accountService.insert(accountModel);
        }
        personService.insert(personModel);
        HttpSession session = request.getSession();
        session.setAttribute("SESSION_KEY", account);
        response.sendRedirect("/index");
        return "index";
    }
}
