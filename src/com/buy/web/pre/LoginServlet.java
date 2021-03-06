package com.buy.web.pre;

import com.buy.entity.EasybuyUser;
import com.buy.service.user.IUserService;
import com.buy.service.user.UserServiceImpl;
import com.buy.utils.EmptyUtils;
import com.buy.utils.ReturnResult;
import com.buy.utils.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet",urlPatterns = {"/login"})
public class LoginServlet extends AbstractServlet {
    //依赖于service层
    IUserService userService;

    @Override
    public void init() throws ServletException {
        userService=new UserServiceImpl();
    }

    //实例化servlet
    @Override
    public Class getServletClass() {
        return LoginServlet.class;
    }

    public String toLogin(HttpServletRequest request, HttpServletResponse response){


        return "/front/login";
    }

    public ReturnResult login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ReturnResult result=new ReturnResult();

        //获取参数：在登录页面输入的用户名和密码
        String loginName=request.getParameter("loginName");
        String password=request.getParameter("password");

        //更具loginName获取用户对象
        EasybuyUser user=userService.getUserByName(loginName);

        //判断用户对象是否存在
        if (EmptyUtils.isEmpty(user)){
            result.returnFail("用户不存在");

        }else {
            //比较用户信息
            if (user.getPassword().equals(SecurityUtils.md5Hex(password))){
                request.getSession().setAttribute("loginUser",user);
                result.returnSuccess("登录成功！");
            }else {
                result.returnFail("密码错误!");
            }
        }
        return  result;

    }
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        //删除session中用户的记录
        request.getSession().removeAttribute("loginUser");
        //
        return "/front/home";


    }






}
