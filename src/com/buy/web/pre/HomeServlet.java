package com.buy.web.pre;

import com.buy.entity.EasybuyProductCategory;
import com.buy.service.product.IProductCategoryService;
import com.buy.service.product.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = {"/home"})
public class HomeServlet extends AbstractServlet {



    IProductCategoryService productCategoryService ;

    @Override
    public void init() throws ServletException {
        productCategoryService = new ProductCategoryServiceImpl();

    }


    public String index(HttpServletRequest request, HttpServletResponse response)throws Exception{
          List<EasybuyProductCategory> categoryList = productCategoryService.queryAllProductCategory("0");

        //存储数据
        request.setAttribute("categoryList",categoryList);

        //页面跳转
        return "/front/home";


    }
    @Override
    public Class getServletClass() {
        return HomeServlet.class;
    }
}

