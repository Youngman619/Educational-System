package com.example.demo.controller;

import com.example.demo.Util.BasicTools;
import com.example.demo.entity.Person;
import com.example.demo.entity.Student;
import com.example.demo.service.PersonService;
import com.example.demo.service.StudentService;
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
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private BasicTools basicTools;
    @Autowired
    private PersonService personService;

    @RequestMapping("/student/doView")
    public String doView(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        HttpSession session = request.getSession();
        if(null != session.getAttribute("SESSION_KEY")){
            model.addAttribute("Email", session.getAttribute("SESSION_KEY"));
        }
        List<Student> list = studentService.selectAll();
        List<Student> removeList = new ArrayList<Student>();
        if(list != null && !list.isEmpty()){
            for (Student student:list){
                if(StringUtils.isEmptyOrWhitespace(student.getPerson().getNation())){
                    student.getPerson().setNation("中国");
                }
                if(StringUtils.isEmptyOrWhitespace(student.getPerson().getProvince())){
                    student.getPerson().setProvince("陕西");
                }
                if(StringUtils.isEmptyOrWhitespace(student.getPerson().getCity())){
                    student.getPerson().setCity("西安");
                }
                if(!StringUtils.isEmptyOrWhitespace(student.getAdmissiontime())){
                    student.setAdmissiontime(basicTools.timestampToDate(student.getAdmissiontime()));
                }
                if("0".equals(student.getStatus())){
                    removeList.add(student);
                }
            }
            list.removeAll(removeList);
            model.addAttribute("studentList", list);
        }
        return "student-datatable";
    }

    @PostMapping("/student/selectOne")
    @ResponseBody
    public Student selectOne(@RequestParam("studentUuid") String studentUuid, HttpServletRequest request, HttpServletResponse response){
        if(!StringUtils.isEmptyOrWhitespace(studentUuid)){
            Student student = studentService.selectByPrimaryKey(studentUuid);
            if(student != null && !StringUtils.isEmptyOrWhitespace(student.getPersonuuid())){
                Person person = personService.selectByPrimaryKey(student.getPersonuuid());
                student.setPerson(person);
            }
            return student;
        }
        return null;
    }

    @PostMapping(value = "/student/addOrUpdate")
    public String addOrUpdate(@RequestParam Map<String,Object> reqMap, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
        String studentUuid = String.valueOf(reqMap.get("studentUuid"));
        String personUuid = String.valueOf(reqMap.get("personUuid"));
        String studentId = String.valueOf(reqMap.get("studentId"));
        String personName = String.valueOf(reqMap.get("personName"));
        String momPhone = String.valueOf(reqMap.get("momPhone"));
        String dadPhone = String.valueOf(reqMap.get("dadPhone"));
        String gender = String.valueOf(reqMap.get("gender"));
        String birthday = String.valueOf(reqMap.get("birthday"));
        String level = String.valueOf(reqMap.get("level"));
        String nation = String.valueOf(reqMap.get("nation"));
        String province = String.valueOf(reqMap.get("province"));
        String city = String.valueOf(reqMap.get("city"));

        Student student = new Student();
        student.setLevel(level);
        student.setStudentid(studentId);
        student.setMomphone(momPhone);
        student.setDadphone(dadPhone);

        Person person = new Person();
        person.setPersonname(personName);
        person.setBirthday(birthday);
        person.setGender(gender);
        person.setNation(nation);
        person.setProvince(province);
        person.setCity(city);
        person.setRole("0"); //0-学生 1-教师 2-管理员

        if(StringUtils.isEmptyOrWhitespace(studentUuid) && StringUtils.isEmptyOrWhitespace(personUuid)){
            studentUuid = basicTools.UUID();
            personUuid = basicTools.UUID();
            student.setUuid(studentUuid);
            student.setPersonuuid(personUuid);
            person.setUuid(personUuid);

            studentService.insert(student);
            personService.insert(person);
        }else {
            student.setUuid(studentUuid);
            student.setPersonuuid(personUuid);
            person.setUuid(personUuid);
            studentService.updateByPrimaryKeySelective(student);
            personService.updateByPrimaryKeySelective(person);
        }
        response.sendRedirect("/student/doView");
        return "student-datatable";
    }

    @PostMapping("/student/deleteOne")
    @ResponseBody
    public String deleteOne(@RequestParam("studentUuid") String studentUuid, HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "error");
        if(!StringUtils.isEmptyOrWhitespace(studentUuid)){
            Student student = studentService.selectByPrimaryKey(studentUuid);
            if(student != null && !StringUtils.isEmptyOrWhitespace(student.getPersonuuid())){
                student.setStatus("0");
                studentService.updateByPrimaryKeySelective(student);
                jsonObject.put("msg", "success");
            }
        }
        return jsonObject.toString();
    }
}
