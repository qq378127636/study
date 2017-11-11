package com.demo.dao;

import com.demo.Demo;

import java.util.List;

/**
 * Created by hxb on 2017/11/4
 */
public interface IDemoDao {

    String findName(Integer id);

    List<Demo> selectByPageNumSize(Demo demo);
}
