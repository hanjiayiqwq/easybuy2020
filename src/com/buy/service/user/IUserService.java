package com.buy.service.user;

import com.buy.entity.EasybuyUser;

public interface IUserService {
    EasybuyUser getUserByName(String loginName) throws Exception;
    boolean save(EasybuyUser user);
}
