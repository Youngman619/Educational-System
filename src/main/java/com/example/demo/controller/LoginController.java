package com.example.demo.controller;

import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/login")
    public String doView(ModelMap model){
        model.addAttribute("Email", "yangq@vmware.com");
        return "login";
    }

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("account") String account, @RequestParam("password") String password, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException{
        String errMsg = "请输入正确的用户名及密码";
        if(!StringUtils.isEmptyOrWhitespace(account) && !StringUtils.isEmptyOrWhitespace(password)){
            boolean isExist = accountService.isExist(account, password);
            if(isExist){
                HttpSession session = request.getSession();
                session.setAttribute("SESSION_KEY", account);
                response.sendRedirect("/index");
                return "index";
            }
        }
        model.addAttribute("errMsg", errMsg);
        return "login";
    }
}