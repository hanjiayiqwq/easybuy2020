package com.buy.text;

import com.buy.dao.user.EasybuyUserImpl;
import com.buy.dao.user.IUser;
import com.buy.entity.EasybuyUser;

public class TestSaveUser {
    public static void main(String[] args) {
        IUser easybuyUser=new EasybuyUserImpl();
        EasybuyUser user=new EasybuyUser();
        user.setUsername("普通用户11");
        user.setType(0);
        user.setPassword("123456");
        user.setLoginname("qwqa");
        user.setSex(0);
        user.setMobile("13887675678");
        user.setIdentitycode("151515151515151515151");
        user.setEmail("guess@qq.com");
        int id=easybuyUser.save(user);
        System.out.println(id);


    }

}
