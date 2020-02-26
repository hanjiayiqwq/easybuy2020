package com.buy.dao.user;

import com.buy.entity.EasybuyUser;
import com.buy.utils.DataSourceUtil;
import com.buy.utils.EmptyUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EasybuyUserImpl extends DataSourceUtil implements IUser {
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

    @Override
    public int save(EasybuyUser user) {
        int num=0;
        try {
            StringBuffer sql = new StringBuffer("INSERT into easybuy_user");
            sql.append("(loginName,userName,password,sex,identityCode,email,mobile,type)");
            sql.append(" values(?,?,?,?,?,?,?,?)");


            conn=DataSourceUtil.getConn();

            pstmt=conn.prepareStatement(sql.toString());
            pstmt.setObject(1,user.getLoginname());
            pstmt.setObject(2,user.getUsername());
            pstmt.setObject(3,user.getPassword());
            pstmt.setObject(4,user.getSex());
            pstmt.setObject(5,user.getIdentitycode());
            pstmt.setObject(6,user.getEmail());
            pstmt.setObject(7,user.getMobile());
            pstmt.setObject(8,user.getType());
            num=pstmt.executeUpdate();


            /*num=this.executeInsert(sql.toString(),user.getLoginname(),user.getUsername()
            ,user.getPassword(),user.getSex(),user.getIdentitycode(),user.getEmail()
            ,user.getMobile(),user.getType());

            user.setId(num);*/

        } catch (Exception e) {
            e.printStackTrace();
            num=-1;
        }

        return num;
    }
}
