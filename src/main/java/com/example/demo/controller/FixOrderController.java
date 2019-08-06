package com.example.demo.controller;

import com.example.demo.Util.BasicTools;
import com.example.demo.entity.FixOrder;
import com.example.demo.entity.Teacher;
import com.example.demo.service.FixOrderService;
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
import java.util.List;
import java.util.Map;

@Controller
public class FixOrderController {

    @Autowired
    private FixOrderService fixOrderService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private BasicTools basicTools;

    @RequestMapping("/fixOrder/doView")
    public String doView(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        HttpSession session = request.getSession();
        if(null != session.getAttribute("SESSION_KEY")){
            model.addAttribute("Email", session.getAttribute("SESSION_KEY"));
        }
        List<FixOrder> list = fixOrderService.selectAll();
        if(list != null && !list.isEmpty()){
            model.addAttribute("fixOrderList", list);
        }
        return "fixOrder-datatable";
    }

    @PostMapping(value = "/fixOrder/addOrUpdate")
    public String addOrUpdate(@RequestParam Map<String,Object> reqMap, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
        String creatorUuid = "";
        String teacherId = String.valueOf(reqMap.get("teacherId"));
        if(!StringUtils.isEmptyOrWhitespace(teacherId)){
            Teacher teacher = teacherService.selectByTeacherId(teacherId);
            creatorUuid = teacher.getUuid();
        }
        if(!StringUtils.isEmptyOrWhitespace(creatorUuid)){
            String theme = String.valueOf(reqMap.get("theme"));
            String detail = String.valueOf(reqMap.get("detail"));
            FixOrder fixOrder = new FixOrder();
            fixOrder.setUuid(basicTools.UUID());
            fixOrder.setOrderid(basicTools.currentTimeNumber());
            fixOrder.setOrdertime(basicTools.currentTimestamp());
            fixOrder.setCreatoruuid(creatorUuid);
            fixOrder.setTheme(theme);
            fixOrder.setDetail(detail);
            fixOrder.setStatus("1"); //0-已完成; 1-待处理

            fixOrderService.insert(fixOrder);
        }
        response.sendRedirect("/fixOrder/doView");
        return "fixOrder-datatable";
    }

    @PostMapping("/fixOrder/deleteOne")
    @ResponseBody
    public String deleteOne(@RequestParam("fixOrderUuid") String fixOrderUuid, @RequestParam("amount") String amount, HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "error");
        if(!StringUtils.isEmptyOrWhitespace(fixOrderUuid)){
            FixOrder fixOrder = fixOrderService.selectByPrimaryKey(fixOrderUuid);
            if(!StringUtils.isEmptyOrWhitespace(amount)){
                amount = String.valueOf(Double.valueOf(amount));
            }
            if(fixOrder != null){
                fixOrder.setStatus("0");
                fixOrder.setAmount(amount);
                fixOrder.setFinishtime(basicTools.currentTimestamp());
                fixOrderService.updateByPrimaryKeySelective(fixOrder);
                jsonObject.put("msg", "success");
            }
        }
        return jsonObject.toString();
    }
}
