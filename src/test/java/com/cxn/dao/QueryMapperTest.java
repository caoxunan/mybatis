package com.cxn.dao;

import com.cxn.model.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @program: mybatis
 * @description: ${description}
 * @author: cxn
 * @create: 2018-04-19 21:06
 * @Version v1.0
 */
public class QueryMapperTest {

    private QueryMapper queryMapper;
    private SqlSession sqlSession;
    @Before
    public void setUp() throws Exception {
        int i = 1/1;
        // 设置资源路径，指定配置文件的位置
        String resource = "mybatis-config.xml";
        // 加载配置文件，获取输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过SqlSessionFactoryBuilder构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取SqlSession对象,true:开启自动提交
        sqlSession = sqlSessionFactory.openSession(true);
        // 开启自动提交
        // 不使用实现类来测试mubatis动态代理实现dao
        // userDao = new UserDaoImpl(sqlSession);
        // 这里通过SqlSession获取指定Mapper接口的代理实现类
        queryMapper = sqlSession.getMapper(QueryMapper.class);
    }

    @Test
    public void queryOrderAndUserByOrderNumber() {
        Order order = queryMapper.queryOrderAndUserByOrderNumber("20140921001");
        System.out.println(order);
    }

    @Test
    public void queryOrderWithUserAndOrderDetailsByOrderNumber(){
        Order order = queryMapper.queryOrderWithUserAndOrderDetailsByOrderNumber("20140921001");
        System.out.println(order);
    }

    @Test
    public void queryOrderUserOrderDetailItemByOrderNumber(){
        Order order = queryMapper.queryOrderUserOrderDetailItemByOrderNumber("20140921001");
        System.out.println(order);
    }

}