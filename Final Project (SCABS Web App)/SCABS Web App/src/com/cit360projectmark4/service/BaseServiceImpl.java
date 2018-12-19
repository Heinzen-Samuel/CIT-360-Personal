package com.cit360projectmark4.service;

import com.cit360projectmark4.dao.BaseDao;
import com.cit360projectmark4.dao.BaseDaoImpl;
import com.cit360projectmark4.pojo.UsersEntity;

public class BaseServiceImpl implements BaseService {
    private BaseDao loginDao = new BaseDaoImpl();

    @Override
    public boolean login(String username, String password) {
        System.out.println("BaseServiceImpl: login: starting login Dao");
        return loginDao.login(username, password);
    }

    @Override
    public String registration(UsersEntity user) {
        System.out.println("BaseServiceImpl: registration: starting registration Dao");
        return loginDao.register(user);
    }
}
