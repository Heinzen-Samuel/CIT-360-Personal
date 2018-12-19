package com.cit360projectmark4.service;

import com.cit360projectmark4.pojo.UsersEntity;

public interface BaseService {
    public boolean login(String username, String password);

    public String registration(UsersEntity user);
}
