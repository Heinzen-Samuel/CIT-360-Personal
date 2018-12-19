package com.cit360projectmark4.dao;

import com.cit360projectmark4.pojo.CapturedEntity;
import com.cit360projectmark4.pojo.ScabsEntity;
import com.cit360projectmark4.pojo.UsersEntity;

import java.util.List;

public interface BaseDao {
    public ScabsEntity getScab(int id);

    public boolean login(String username, String password);

    public String register(UsersEntity user);

    public String recordCalories(String username, String string_calories);

    public String useCalories(String username, int calories);

    public String storeCapturedScab(CapturedEntity new_scab);

    public List<CapturedEntity> getCapturedScabs(String username);
}
