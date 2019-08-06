package com.example.demo.controller;

import com.example.demo.Util.BasicTools;
import com.example.demo.entity.Lesson;
import com.example.demo.entity.Schedule;
import com.example.demo.service.LessonService;
import com.example.demo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private LessonService lessonService;
    @Autowired
    private BasicTools basicTools;

    @PostMapping("/schedule/selectAll")
    @ResponseBody
    public List<Schedule> selectAll(HttpServletRequest request, HttpServletResponse response){
        return scheduleService.selectAll();
    }

    @PostMapping(value = "/schedule/addOrUpdate")
    public String addOrUpdate(@RequestParam Map<String,Object> reqMap, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
        String lessonUuid = String.valueOf(reqMap.get("lessonUuid"));
        String teacherUuid = String.valueOf(reqMap.get("teacherUuid"));
        String currentDate = String.valueOf(reqMap.get("currentDate"));
        String startTime = String.valueOf(reqMap.get("startTime"));
        String endTime = String.valueOf(reqMap.get("endTime"));
        String lessonType = "";
        Lesson lesson = lessonService.selectByPrimaryKey(lessonUuid);
        if(lesson != null){
            lessonType = lesson.getLessontype();
        }
        if(!StringUtils.isEmptyOrWhitespace(startTime)){
            startTime = currentDate + " " + startTime + ":00";
        }
        if(!StringUtils.isEmptyOrWhitespace(endTime)){
            endTime = currentDate + " " + endTime + ":00";
        }
        Schedule schedule = new Schedule();
        schedule.setUuid(basicTools.UUID());
        schedule.setScheduleid(basicTools.currentTimeNumber());
        schedule.setLessonuuid(lessonUuid);
        schedule.setLessontype(lessonType);
        schedule.setStarttime(startTime);
        schedule.setEndtime(endTime);
        schedule.setTeacheruuid(teacherUuid);
        schedule.setStatus("1");

        scheduleService.insert(schedule);

        response.sendRedirect("/index");
        return "index";
    }
}
