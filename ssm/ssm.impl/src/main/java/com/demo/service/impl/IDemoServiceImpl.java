package com.demo.service.impl;

import com.demo.dao.IDemoDao;
import com.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by hxb on 2017/11/4
 */
@Service
public class IDemoServiceImpl implements IDemoService{

    @Autowired
    private IDemoDao iDemoDao;

    @Override
    public String findName(Integer id) {

        return iDemoDao.findName(id);
    }
}
