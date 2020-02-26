package com.buy.text;

import com.buy.dao.user.EasybuyUserImpl;
import com.buy.entity.EasybuyUser;

public class TestUserLogin {
    public static void main(String[] args) throws Exception {
        EasybuyUserImpl user=new EasybuyUserImpl();
        EasybuyUser admin=user.getUserByloginName("admin");
        System.out.println(admin.getPassword());
    }
}
