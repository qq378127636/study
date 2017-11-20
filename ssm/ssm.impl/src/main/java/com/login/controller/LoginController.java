package com.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import utils.SpringUtil;



@Controller
public class LoginController {



    /**
     * 登陆验证
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(String userName, String passWord){


        //验证通过：重定向到主页
        if(userName != null && passWord != null){

            SpringUtil.getSession().setAttribute("userName", userName);//存储session

            return "redirect:/index";
        }

        //验证不通过：重定向到登陆页面
        else
            return "redirect:/login.html";
    }



    /**
     * 主页跳转
     */
    @RequestMapping("/index")
    public String index(){

        return "index";
    }



    /**
     * 退出
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


关于重定向：
    主页被设计成保密的，登陆后才能访问，所以放在WEB-INF里面，因此采用后台重定向才能访问主页

    重定向的使用
        方法返回的URI（相对路径）中加上"redirect:"前缀，声明要重定向到该地址
        使用HttpServletResponse对象进行重定向

        注意：
             1) "redirect:"后面跟着"/"： 说明该URI是相对于项目的Context ROOT的相对路径
             2) "redirect:"后面没有跟着"/"： 说明该URI是相对于当前路径

关于jsessionid:
    为什么url上会携带jsessionid？
        重定向时，代码 “redirect:/index” ，服务器会判断请求头是否带有cookie；
        如果没有，则对该url重写，并在返回的url上追加jsessionid。

    为什么首次访问才出现jsessionid？
        一般第一次访问的时候，客户端是不存在cookie，所以服务器会重写url，返回jsessionid给客户端；
        当客户端收到了服务器返回的jsessionid后再访问时会携带该jesessionid，所以之后服务器就不会重写url，因此url上也不会显示jsessionid了。
*/
