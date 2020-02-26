package com.buy.web.pre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegiserServlet",urlPatterns = "/register")
public class RegiserServlet extends AbstractServlet {
    @Override
    public Class getServletClass() {
        return null;
    }

    public String toRegiser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/front/register";
    }

    public void doRegiser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
