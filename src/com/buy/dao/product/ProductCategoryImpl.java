package com.buy.dao.product;

import com.buy.entity.EasybuyProductCategory;
import com.buy.utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryImpl implements IProductCategory {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Override
    public List<EasybuyProductCategory> queryAllProductCategory(String parentId) {
        List<EasybuyProductCategory> productCategories=new ArrayList<EasybuyProductCategory>();
        EasybuyProductCategory productCategory=null;


        try {
            StringBuffer sql=new StringBuffer();
            sql.append("select * from easybuy_product_category where 1=1 ");



            //获取连接
             conn= DataSourceUtil.getConn();
             pstmt=conn.prepareStatement(sql.toString());
            //pstmt.setString(1,parentId);

            //判断parentID的值，如果为0，显示的是一级分类
            if (!"".equals(parentId) || null!=parentId){
                sql.append("and parentId = 0");
            }

             rs =pstmt.executeQuery();

            //处理结果集
            while (rs.next()){
                //实例化对象
                productCategory=new EasybuyProductCategory();
                productCategory.setId(rs.getInt(1));
                productCategory.setName(rs.getString(2));
                productCategory.setParentid(rs.getInt(3));
                productCategory.setType(rs.getInt(4));
                productCategory.setIconclass(rs.getString(5));

                //将对象填充到集合
                productCategories.add(productCategory);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productCategories;
    }
}
