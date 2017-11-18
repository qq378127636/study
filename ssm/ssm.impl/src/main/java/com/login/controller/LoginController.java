package com.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.SpringUtil;

import javax.servlet.http.HttpSession;

/**
 * (用一句话描述该文件做什么)
 *
 * @author DaHuanDan
 * @create 2017/11/18
 */

@Controller
public class LoginController {


    /**
     * 登陆
     * @param userName
     * @param passWord
     * @return
     */
    @RequestMapping("/signIn")
    public String login(String userName, String passWord){


        //验证通过：重定向到主页
        if(userName != null && userName !=""){

            SpringUtil.getSession().setAttribute("userName", userName);//存储session

            return "redirect:/index.html";
        }

        //验证不通过：重定向到登陆页面
        else
            return "redirect:/login.html";
    }
}












/*
方法返回的URI（相对路径）中加上"redirect:"前缀，声明要重定向到该地址

使用HttpServletResponse对象进行重定向

注意：
     1) "redirect:"后面跟着"/"： 说明该URI是相对于项目的Context ROOT的相对路径
     2) "redirect:"后面没有跟着"/"： 说明该URI是相对于当前路径
*/
