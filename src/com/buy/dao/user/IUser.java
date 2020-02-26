package com.buy.dao.user;

import com.buy.entity.EasybuyUser;

public interface IUser {
    EasybuyUser getUserByloginName(String loginName) throws Exception;
}
