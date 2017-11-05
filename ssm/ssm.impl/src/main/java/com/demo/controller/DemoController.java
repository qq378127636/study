package com.demo.controller;

import com.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
