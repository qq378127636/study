package com.demo.service;

import com.demo.Demo;

import java.util.Map;

public interface IDemoService {

    String findName(Integer id);

    Map<String,Object> findList(Demo demo);
}
