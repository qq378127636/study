package com.error;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description : 全局异常处理器
 * @Author : DaHuaiDan
 * @Create : 2017/12/3 17:51
 * @Version : 1.0
 */
public class SsmExceptionResolver implements HandlerExceptionResolver {


    private static final Logger log = LogManager.getLogger(SsmExceptionResolver.class);


    /**  
     * 前端控制器DispatcherServlet在进行HandlerMapping、调用HandlerAdapter执行Handler过程中，如果遇到异常就会执行此方法
     *
     * @param request
     * @param response
     * @param handler最终要执行的Handler,它的真实身份是HandlerMethod
     * @param
     * @return org.springframework.web.servlet.ModelAndView  
     */  
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {

        promptMessage(response, exceptionHandler(e));

        return new ModelAndView();
    }



    /**
     * 异常处理
     * @param e
     * @return SsmExcetion
     */
    private SsmExcetion exceptionHandler(Exception e){

        //记录日志
        log.error(e.getMessage() + "\r\n", e);

        SsmExcetion ssmExcetion = null;

        //异常转换
        if(e instanceof SsmExcetion)
            ssmExcetion = (SsmExcetion)e;   //自定义的异常，直接取出异常信息
        else
            ssmExcetion = new SsmExcetion("未知错误！"); //针对非CustomException异常，对这类重新构造成一个CustomException，异常信息为“未知错误”

        return ssmExcetion;
    }



    /**
     * 提示客户异常信息
     * @param response
     * @param e
     */
    private void promptMessage(HttpServletResponse response, Exception e){

        response.setStatus(HttpStatus.OK.value()); //设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");


        try {
            response.getWriter().write("<script language=\\\"javascript\\\">promptMessage.$alert('错误信息：  "+ e.getMessage() + " ', '系统异常', {confirmButtonText: '确定'});</script>");
        }
        catch (IOException oe) {
            log.error("与客户端通讯异常:"+ oe.getMessage(), oe);
        }
    }
}
