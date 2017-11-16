package com.demo.service;

import com.demo.Demo;

import java.util.Map;

/**
 * Created by hxb on 2017/11/4
 */
public interface IDemoService {

    String findName(Integer id);

    Map<String,Object> findList(Demo demo);
}
