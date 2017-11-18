package com.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
     * 登陆验证
     * @param userName
     * @param passWord
     * @return
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(String userName, String passWord){


        //验证通过：重定向到主页
        if(userName != null && userName !=""){

            SpringUtil.getSession().setAttribute("userName", userName);//存储session

            return "redirect:/index";
        }

        //验证不通过：重定向到登陆页面
        else
            return "redirect:/login.html";
    }


    /**
     * 主页跳转
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    /**
     * 退出
     * @return
     */
    @RequestMapping("/signOut")
    public String signOut(){

        SpringUtil.getSession().removeAttribute("userName");

        return "redirect:/login.html";
    }
}












/*
登陆：

关于post、get：
    在登陆时，账号密码是保密的，所以采用post请求方式登陆


关于重定向的问题：
    主页被设计成保密的，登陆后才能访问，所以放在WEB-INF里面，因此采用后台重定向才能访问主页

    重定向的使用
        方法返回的URI（相对路径）中加上"redirect:"前缀，声明要重定向到该地址
        使用HttpServletResponse对象进行重定向

        注意：
             1) "redirect:"后面跟着"/"： 说明该URI是相对于项目的Context ROOT的相对路径
             2) "redirect:"后面没有跟着"/"： 说明该URI是相对于当前路径
*/
