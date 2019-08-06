package com.example.demo.controller;

import com.example.demo.Util.BasicTools;
import com.example.demo.entity.Person;
import com.example.demo.entity.Teacher;
import com.example.demo.service.AccountService;
import com.example.demo.service.PersonService;
import com.example.demo.service.TeacherService;
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
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private BasicTools basicTools;
    @Autowired
    private AccountService accountService;
    @Autowired
    private PersonService personService;

    @RequestMapping("/teacher/doView")
    public String doView(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        HttpSession session = request.getSession();
        if(null != session.getAttribute("SESSION_KEY")){
            model.addAttribute("Email", session.getAttribute("SESSION_KEY"));
        }
        List<Teacher> list = teacherService.selectAll();
        List<Teacher> removeList = new ArrayList<Teacher>();
        if(list != null && !list.isEmpty()){
            for (Teacher teacher:list){
                if(StringUtils.isEmptyOrWhitespace(teacher.getPerson().getNation())){
                    teacher.getPerson().setNation("中国");
                }
                if(StringUtils.isEmptyOrWhitespace(teacher.getPerson().getProvince())){
                    teacher.getPerson().setProvince("陕西");
                }
                if(StringUtils.isEmptyOrWhitespace(teacher.getPerson().getCity())){
                    teacher.getPerson().setCity("西安");
                }
                if(!StringUtils.isEmptyOrWhitespace(teacher.getEntrytime())){
                    teacher.setEntrytime(basicTools.timestampToDate(teacher.getEntrytime()));
                }
                if("0".equals(teacher.getStatus())){
                    removeList.add(teacher);
                }
            }
            list.removeAll(removeList);
            model.addAttribute("teacherList", list);
        }
        return "teacher-datatable";
    }

    @PostMapping("/teacher/selectOne")
    @ResponseBody
    public Teacher selectOne(@RequestParam("teacherUuid") String teacherUuid, HttpServletRequest request, HttpServletResponse response){
        if(!StringUtils.isEmptyOrWhitespace(teacherUuid)){
            Teacher teacher = teacherService.selectByPrimaryKey(teacherUuid);
            if(teacher != null && !StringUtils.isEmptyOrWhitespace(teacher.getPersonuuid())){
                Person person = personService.selectByPrimaryKey(teacher.getPersonuuid());
                teacher.setPerson(person);
            }
            return teacher;
        }
        return null;
    }

    @PostMapping(value = "/teacher/addOrUpdate")
    public String addOrUpdate(@RequestParam Map<String,Object> reqMap, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException{
        String teacherUuid = String.valueOf(reqMap.get("teacherUuid"));
        String personUuid = String.valueOf(reqMap.get("personUuid"));
        String teacherId = String.valueOf(reqMap.get("teacherId"));
        String personName = String.valueOf(reqMap.get("personName"));
        String phone = String.valueOf(reqMap.get("phone"));
        String gender = String.valueOf(reqMap.get("gender"));
        String birthday = String.valueOf(reqMap.get("birthday"));
        String level = String.valueOf(reqMap.get("level"));
        String nation = String.valueOf(reqMap.get("nation"));
        String province = String.valueOf(reqMap.get("province"));
        String city = String.valueOf(reqMap.get("city"));

        Teacher teacher = new Teacher();
        teacher.setLevel(level);
        teacher.setTeacherid(teacherId);

        Person person = new Person();
        person.setPersonname(personName);
        person.setBirthday(birthday);
        person.setGender(gender);
        person.setPhone(phone);
        person.setNation(nation);
        person.setProvince(province);
        person.setCity(city);
        person.setRole("1"); //0-学生 1-教师 2-管理员

        if(StringUtils.isEmptyOrWhitespace(teacherUuid) && StringUtils.isEmptyOrWhitespace(personUuid)){
            teacherUuid = basicTools.UUID();
            personUuid = basicTools.UUID();
            teacher.setUuid(teacherUuid);
            teacher.setPersonuuid(personUuid);
            person.setUuid(personUuid);

            teacherService.insert(teacher);
            personService.insert(person);
        }else {
            teacher.setUuid(teacherUuid);
            teacher.setPersonuuid(personUuid);
            person.setUuid(personUuid);
            teacherService.updateByPrimaryKeySelective(teacher);
            personService.updateByPrimaryKeySelective(person);
        }
        response.sendRedirect("/teacher/doView");
        return "teacher-datatable";
    }

    @PostMapping("/teacher/deleteOne")
    @ResponseBody
    public String deleteOne(@RequestParam("teacherUuid") String teacherUuid, HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "error");
        if(!StringUtils.isEmptyOrWhitespace(teacherUuid)){
            Teacher teacher = teacherService.selectByPrimaryKey(teacherUuid);
            if(teacher != null && !StringUtils.isEmptyOrWhitespace(teacher.getPersonuuid())){
                teacher.setStatus("0");
                teacherService.updateByPrimaryKeySelective(teacher);
                jsonObject.put("msg", "success");
            }
        }
        return jsonObject.toString();
    }
}
