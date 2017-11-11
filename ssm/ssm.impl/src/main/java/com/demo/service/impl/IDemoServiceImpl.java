package com.demo.service.impl;

import com.demo.Demo;
import com.demo.dao.IDemoDao;
import com.demo.service.IDemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


/**
 * Created by hxb on 2017/11/4
 */
@Service
public class IDemoServiceImpl implements IDemoService{

    @Resource
    private IDemoDao iDemoDao;

    @Override
    public String findName(Integer id) {

        return iDemoDao.findName(id);
    }

    @Override
    public Map<String, Object> findList(Demo demo) {
        iDemoDao.selectByPageNumSize(demo);
        return null;
    }
}
