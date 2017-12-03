package com.demo.controller;

import com.demo.Demo;
import com.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/send_demo_page")
    public String send_demo_Page() throws Exception {

        if (1==1)
            throw new ArrayIndexOutOfBoundsException("aaaabbbbcccc");

        return "demo/demo2";
    }


    @RequestMapping("/findName")
    @ResponseBody
    public String findName() throws Exception {
        return iDemoService.findName(1);
    }

    @RequestMapping("/findList")
    @ResponseBody
    public String findList2(String str) throws Exception {
        return "123";
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

    public static void main(String[] args) {
        System.out.println("a" + "\r\n" +"b");
    }
}


