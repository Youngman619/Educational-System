package com.example.demo.controller;

import com.example.demo.Util.BasicTools;
import com.example.demo.entity.Lesson;
import com.example.demo.service.LessonService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LessonController {

    @Autowired
    private LessonService lessonService;
    @Autowired
    private BasicTools basicTools;

    @RequestMapping("/lesson/doView")
    public String doView(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        HttpSession session = request.getSession();
        if(null != session.getAttribute("SESSION_KEY")){
            model.addAttribute("Email", session.getAttribute("SESSION_KEY"));
        }
        List<Lesson> list = lessonService.selectAll();
        List<Lesson> removeList = new ArrayList<Lesson>();
        if(list != null && !list.isEmpty()){
            for (Lesson lesson:list){
                if("0".equals(lesson.getStatus())){
                    removeList.add(lesson);
                }
            }
            list.removeAll(removeList);
            model.addAttribute("lessonList", list);
        }
        return "lesson-datatable";
    }

    @PostMapping("/lesson/selectOne")
    @ResponseBody
    public Lesson selectOne(@RequestParam("lessonUuid") String lessonUuid, HttpServletRequest request, HttpServletResponse response){
        if(!StringUtils.isEmptyOrWhitespace(lessonUuid)){
            Lesson lesson = lessonService.selectByPrimaryKey(lessonUuid);
            if(lesson != null){
                return lesson;
            }
        }
        return null;
    }

    @PostMapping(value = "/lesson/addOrUpdate")
    public String addOrUpdate(@RequestParam Map<String,Object> reqMap, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
        String lessonUuid = String.valueOf(reqMap.get("lessonUuid"));
        String lessonId = String.valueOf(reqMap.get("lessonId"));
        String lessonName = String.valueOf(reqMap.get("lessonName"));
        String lessonType = String.valueOf(reqMap.get("lessonType"));
        String startTime = String.valueOf(reqMap.get("startTime"));
        String endTime = String.valueOf(reqMap.get("endTime"));

        Lesson lesson = new Lesson();
        lesson.setLessonid(lessonId);
        lesson.setLessonname(lessonName);
        lesson.setLessontype(lessonType);
        lesson.setStarttime(startTime);
        lesson.setEndtime(endTime);

        if(StringUtils.isEmptyOrWhitespace(lessonUuid)){
            lessonUuid = basicTools.UUID();
            lesson.setUuid(lessonUuid);
            lesson.setStatus("1");
            lessonService.insert(lesson);
        }else{
            lessonService.updateByPrimaryKeySelective(lesson);
        }
        response.sendRedirect("/lesson/doView");
        return "lesson-datatable";
    }

    @PostMapping("/lesson/deleteOne")
    @ResponseBody
    public String deleteOne(@RequestParam("lessonUuid") String lessonUuid, HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "error");
        if(!StringUtils.isEmptyOrWhitespace(lessonUuid)){
            Lesson lesson = lessonService.selectByPrimaryKey(lessonUuid);
            if(lesson != null){
                lesson.setStatus("0");
                lessonService.updateByPrimaryKeySelective(lesson);
                jsonObject.put("msg", "success");
            }
        }
        return jsonObject.toString();
    }
}
