package com.buy.dao.user;

import com.buy.entity.EasybuyUser;
import com.buy.utils.EmptyUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.buy.utils.DataSourceUtil.getConn;

public class EasybuyUserImpl implements IUser {
    Connection conn=null;
    PreparedStatement pstmt;
    ResultSet rs;
    public EasybuyUser TableClass(ResultSet rs)throws Exception{
        EasybuyUser user=new EasybuyUser();
        user.setEmail(rs.getString("email"));
        user.setId(rs.getInt("id"));
        user.setIdentitycode(rs.getString("identitycode"));
        user.setLoginname(rs.getString("loginname"));
        user.setUsername(rs.getString("username"));
        user.setMobile(rs.getString("mobile"));
        user.setPassword(rs.getString("password"));
        user.setSex(rs.getInt("sex"));
        user.setType(rs.getInt("type"));

        return user;
    }
    @Override
    public EasybuyUser getUserByloginName(String loginName) throws Exception {
        EasybuyUser user=null;

        //编写sql语句
        StringBuffer sql=new StringBuffer("SELECT * FROM easybuy_user WHERE 1=1 AND loginName='admin'");
        //判断用户名是否为空
        if (!EmptyUtils.isEmpty(loginName)){
            sql.append("AND loginName = ?");

        }
        //执行sql
        conn=getConn();
        pstmt=conn.prepareStatement(sql.toString());
        pstmt.setObject(1,loginName);
        rs=pstmt.executeQuery();

        //rs=this.executeQuery(sql.toString(),loginName);
        while (rs.next()){
            user=TableClass(rs);

        }

        return user;
    }
}
