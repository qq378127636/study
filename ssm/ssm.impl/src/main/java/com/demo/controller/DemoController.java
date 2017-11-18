package com.demo.controller;

import com.demo.Demo;
import com.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.SpringUtil;

/**
 * Created by hxb on 2017/11/4
 */
@RequestMapping("/demo")
@Controller
public class DemoController {

    @Autowired
    private IDemoService iDemoService;

    @RequestMapping("/findName")
    @ResponseBody
    public String findName() throws Exception {
        return iDemoService.findName(1);
    }

    @RequestMapping("/findList2")
    @ResponseBody
    public String grid(@RequestParam("ids[]") String[] ids) throws Exception {
        System.out.println(ids[0]);
        System.out.println(ids[1]);
        System.out.println("1");
        return "";
    }


    @RequestMapping("/grid")
    public String grid() throws Exception {
        return "demo/demo";
    }

    @RequestMapping("/findUser")
    @ResponseBody
    public String findList( Demo demo) throws Exception {
        return (String) SpringUtil.getSession().getAttribute("userName");
    }


    /**
     * 参数传递
     * String[]、int[]数据类型需要使用@RequestParam("ids[]")
     */
}


