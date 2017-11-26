package com.login.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import utils.SpringUtil;



@Controller
public class LoginController {



    /**
     * 登陆验证
     *          这里把登陆和shiro认证的逻辑放在一起，原因是可以判断用户登陆状态，从而返回对应页面
     *          例如，用户请求登陆页面时，如果已经登陆过，再次登陆的话，我们可以直接跳转到主页，这样更友好！
     */
    @RequestMapping("/signIn")
    public String signIn(String username, String passpord){

        //认证成功跳转到主页
        if(SecurityUtils.getSubject().isAuthenticated())
            return "redirect:index";

        return "login";
    }



    /**
     * 主页跳转
     */
    @RequestMapping("/index")
    public String index(){

        return "index";
    }
}












/*
登陆：

关于逻辑：
	1、所有请求必须先登陆：只提供一个登陆入口
	2、再次请求登陆入口的显示页面：判断是否认证成功，成功：显示主页，失败：显示登陆页面

关于post、get：
    在登陆时，账号密码是保密的，所以采用post请求方式登陆


关于重定向：
    显示登陆页面时：地址应该是登陆的地址
	显示主页时：地址应该是主页地址

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
