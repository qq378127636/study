package utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * (用一句话描述该文件做什么)
 *
 * @author DaHuanDan
 * @create 2017/11/18
 */

public class SpringUtil {

    /**
     * 获取Session
     * @return
     */
    public static HttpSession getSession() {
        HttpSession session = null;
        session = getRequest().getSession();
        return session;
    }


    /**
     * 获取request
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }
}
