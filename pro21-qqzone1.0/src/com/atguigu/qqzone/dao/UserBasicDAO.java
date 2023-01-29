package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicDAO {
    public UserBasic getUserBasic (String loginId, String pwd);

    public List<UserBasic> getUserBasicList(UserBasic userBasic);
}
