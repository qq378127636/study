package com.error;

/**
 * @Description : 全局自定义异常类：系统其他模块的异常需要实现此类
 * @Author : DaHuaiDan
 * @Create : 2017/12/3 17:31
 * @Version : 1.0
 */

public class SsmExcetion extends Exception{

    private  String message;


    public SsmExcetion(String message) {
        super(message);
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


/**
 * 关于全局异常处理：
 *
 *      关于概念：
 *          java的异常体系：
 *              Throwable
 *                  -Error ：外部错误
 *                  -Exception：内部错误，即代码错误
 *          我们要处理的就是Exception，Exception又分为RunnTimeException和预编译异常，
 *          其中RunnTimeException是要依靠我们严谨的代码来解决，
 *          而预编译的异常就是我们全局异常处理的目标，通俗点说就是需要try catch的异常。
 *                      -
 *      关于优点：
 *          有利于代码的简洁（不需要重复的try catch，统一放在全局异常处理）；
 *          集中系统的异常管理，给用户更好的体验。
 *
 *      关于实现：
 *          三层代码的异常全部往上抛出；
 *          创建系统自定义异常类，统一管理自定义异常，所有模块的自定义异常继承系统自定义异常类；
 *          创建系统统一异常处理器类，实现springmvc的HandlerExceptionResolver接口
 *
 *
 *      关于处理：
 *          全局异常处理的是controller里的handler,
 *          也就是说像那些不能进handler的404、405、500还需要另外处理；
 *          而能进handler的统一在前端用弹出框提示异常信息。
 *
 */
