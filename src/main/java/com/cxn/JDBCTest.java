package com.cxn;

import java.sql.*;

/**
 * @program: mybatis
 * @description: 回顾jdbc操作
 * @author: cxn
 * @create: 2018-04-19 11:01
 * @Version v1.0
 */
public class JDBCTest {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 准备数据库连接的4个参数
            String className = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mybatis-test";
            String user = "root";
            String password = "123456";
            // 1、注册驱动
            Class.forName(className);
            // 2、获得连接
            connection = DriverManager.getConnection(url, user, password);
            // 3、获得发送sql的对象
            String sql = "select * from tbl_user";
            statement = connection.prepareStatement(sql);
            // 4、发送sql获得结果
            resultSet = statement.executeQuery();
            // 6、解析结果
            while (resultSet.next()){
                System.out.println("id:" + resultSet.getInt("id"));
                System.out.println("age:" + resultSet.getInt("age"));
                System.out.println("name:" + resultSet.getString("name"));
                System.out.println("address:" + resultSet.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7.释放资源
            try {
                if( resultSet != null){
                    resultSet.close();
                }
                // 这样写不合适，应该每个资源单独一个try
                if( statement != null){
                    statement.close();
                }
                if( connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
