package com.buy.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtil {

        private final static String DRIVER="com.mysql.jdbc.Driver";
        private final static String URL="jdbc:mysql://localhost:3306/easybuy?useUnicode=true&amp&characterEncoding=utf-8";
        private final static String USER="root";
        private final static String PASSWORD="123456";

        //创建druid数据源对象
        private static DruidDataSource druidDataSource=null;

        static {
            try {
                init();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        /**
         * 配置阿里巴巴数据源
         */



        public  static void init() throws SQLException {
            //实例化DruidDataSource
            druidDataSource=new DruidDataSource();
            //设置属性的值
            druidDataSource.setDriverClassName(DRIVER);
            druidDataSource.setUrl(URL);
            //设置连接池相关属性
            druidDataSource.setInitialSize(5);//初始化连接池数量
            druidDataSource.setMaxActive(100);//最大连接数
            druidDataSource.setMinIdle(1);//最大空闲连接数
            druidDataSource.setMaxWait(1000);//连接等待时长，单位：毫秒
            druidDataSource.setFilters("stat");//设置监控

        }

        /**
         * 连接数据源的方法
         * @return 连接对象
         */
        public static Connection getConn(){
            Connection conn=null;
            //加载mysql驱动（开启服务）
            try {
                Class.forName(DRIVER);
                //如果数据库处于没有连接状态，则创建一个连接
                if (conn == null) {
                    conn = druidDataSource.getConnection(USER,PASSWORD);
                    System.out.println("数据库连接成功。");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }

    /**
     * 关闭连接的方法
     * @param conn
     */
    public static  void  closeConnection(Connection conn){
            if (conn== null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



}
