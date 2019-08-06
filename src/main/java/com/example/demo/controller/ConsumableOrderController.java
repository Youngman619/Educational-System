package com.example.demo.controller;

import com.example.demo.Util.BasicTools;
import com.example.demo.entity.ConsumableOrder;
import com.example.demo.entity.Teacher;
import com.example.demo.service.ConsumableOrderService;
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
public class ConsumableOrderController {

    @Autowired
    private ConsumableOrderService consumableOrderService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private BasicTools basicTools;

    @RequestMapping("/consumableOrder/doView")
    public String doView(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        HttpSession session = request.getSession();
        if(null != session.getAttribute("SESSION_KEY")){
            model.addAttribute("Email", session.getAttribute("SESSION_KEY"));
        }
        List<ConsumableOrder> list = consumableOrderService.selectAll();
        if(list != null && !list.isEmpty()){
            model.addAttribute("consumableOrderList", list);
        }
        return "consumableOrder-datatable";
    }

    @PostMapping(value = "/consumableOrder/addOrUpdate")
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
            ConsumableOrder consumableOrder = new ConsumableOrder();
            consumableOrder.setUuid(basicTools.UUID());
            consumableOrder.setOrderid(basicTools.currentTimeNumber());
            consumableOrder.setOrdertime(basicTools.currentTimestamp());
            consumableOrder.setCreatoruuid(creatorUuid);
            consumableOrder.setTheme(theme);
            consumableOrder.setDetail(detail);
            consumableOrder.setStatus("1"); //0-已完成; 1-待处理

            consumableOrderService.insert(consumableOrder);
        }
        response.sendRedirect("/consumableOrder/doView");
        return "consumableOrder-datatable";
    }

    @PostMapping("/consumableOrder/deleteOne")
    @ResponseBody
    public String deleteOne(@RequestParam("consumableOrderUuid") String consumableOrderUuid, @RequestParam("amount") String amount, HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "error");
        if(!StringUtils.isEmptyOrWhitespace(consumableOrderUuid)){
            ConsumableOrder consumableOrder = consumableOrderService.selectByPrimaryKey(consumableOrderUuid);
            if(!StringUtils.isEmptyOrWhitespace(amount)){
                amount = String.valueOf(Double.valueOf(amount));
            }
            if(consumableOrder != null){
                consumableOrder.setStatus("0");
                consumableOrder.setAmount(amount);
                consumableOrder.setFinishtime(basicTools.currentTimestamp());
                consumableOrderService.updateByPrimaryKeySelective(consumableOrder);
                jsonObject.put("msg", "success");
            }
        }
        return jsonObject.toString();
    }
}
