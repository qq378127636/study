package com.shiro;

import java.util.Date;

public class User {
    private Integer id;

    /**
     * 用户名称
     *
     * @mbg.generated
     */
    private String username;

    /**
     * 用户密码
     *
     * @mbg.generated
     */
    private String password;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createtime;

    /**
     * 登陆时间
     *
     * @mbg.generated
     */
    private Date logintime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }
}