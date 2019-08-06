package com.example.demo.controller;

import com.example.demo.entity.Lesson;
import com.example.demo.entity.Teacher;
import com.example.demo.service.LessonService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private LessonService lessonService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        HttpSession session = request.getSession();
        if(null != session.getAttribute("SESSION_KEY")){
            model.addAttribute("Email", session.getAttribute("SESSION_KEY"));

            List<Lesson> lessonList = lessonService.selectAll();
            List<Teacher> teacherList = teacherService.selectAll();
            if(!lessonList.isEmpty()){
                model.addAttribute("lessonList", lessonList);
            }
            if(!teacherList.isEmpty()){
                model.addAttribute("teacherList", teacherList);
            }
            return "index";
        }
        return "login";

    }
}
