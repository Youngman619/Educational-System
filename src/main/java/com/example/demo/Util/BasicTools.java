package com.example.demo.Util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.UUID;

@Component
public class BasicTools {

    public String UUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public String currentTimestamp(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(System.currentTimeMillis());
    }

    public String timestampToDate(String timestamp){
        return timestamp.substring(0,10);
    }

    public String currentTimeNumber(){
        String timeStamp = this.currentTimestamp();
        timeStamp = timeStamp.replaceAll("-","").replaceAll(" ","").replaceAll(":","");
        return timeStamp;
    }

    public static void main(String args[]){
        BasicTools basicTools = new BasicTools();
        System.out.println(basicTools.UUID());
        System.out.println(basicTools.currentTimeNumber());
        System.out.println(basicTools.currentTimestamp());
    }
}
