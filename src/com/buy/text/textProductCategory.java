package com.buy.text;

import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCategoryImpl;
import com.buy.entity.EasybuyProductCategory;

import java.util.List;

public class textProductCategory {
    public static void main(String[] args) {
        IProductCategory productCategory=new ProductCategoryImpl();

       List<EasybuyProductCategory>productCategories= productCategory.queryAllProductCategory("0");
        for (EasybuyProductCategory category: productCategories) {
            System.out.println(category.getName());
            
        }
   
   
    }


}
