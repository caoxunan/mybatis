package com.cxn;


import com.cxn.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @program: mybatis
 * @description: 使用mybatis查询数据库
 * @author: cxn
 * @create: 2018-04-19 13:46
 * @Version v1.0
 */
public class MybatisTest {
    public static void main(String[] args) throws  Exception{
        // 设置资源路径，指定配置文件的位置
        String resource = "mybatis-config.xml";
        // 加载配置文件，获取输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过SqlSessionFactoryBuilder构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行指定的statement，完成查询
        User user = sqlSession.selectOne("namespace1.getById",1);
        System.out.println(user);
    }
}
