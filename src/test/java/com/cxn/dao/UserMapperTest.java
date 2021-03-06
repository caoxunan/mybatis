package com.cxn.dao;

import com.cxn.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatis
 * @description: 单表增删改查junit测试
 * @author: cxn
 * @create: 2018-04-19 14:23
 * @Version v1.0
 */
public class UserMapperTest {

    private UserMapper userMapper;
    private SqlSession sqlSession;
    @Before
    public void setUp() throws Exception {
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
         userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void getById() {
        User user = userMapper.getById(1);
        System.out.println(user);
    }
    @Test
    public void getByName() {
        List<User> users = userMapper.getByName("小米");

        for (User user : users) {
            System.out.println(user);
        }

        List<User> users1 = userMapper.getByName("");
        for (User user : users1) {
            System.out.println(user);
        }

    }

    @Test
    public void queryAll() {

        List<User> users = userMapper.queryAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("zhangsan");
        user.setAddress("beijingchaoyang");
        user.setAge(30);
        userMapper.insertUser(user);
        System.out.println("id回显：" + user);
    }

    @Test
    public void updateUser() {
        User user = userMapper.getById(1);
        user.setAddress("中文");
        user.setName("");
        userMapper.updateUser(user);
    }

    @Test
    public void removeUser() {
        userMapper.removeUser(6);
    }

    @Test
    public void queryAllUserBySort(){
        List<User> users = userMapper.queryAllUserBySort(15);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserByNameAndAge(){
        List<User> users = userMapper.queryUserByNameAndAge("", 16);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserByIds(){
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(11);
        ids.add(8);
        List<User> users = userMapper.queryUserByIds(ids);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testLevel1Cache(){
        // one session
        // first query
        User user = userMapper.getById(1);
        System.out.println(user);
        // 如果此时有做增删改操作，会清空缓存
        // userMapper.removeUser(11);
        // 手动清除缓存
        sqlSession.clearCache();
        User user2 = userMapper.getById(1);
        System.out.println(user2);
    }

}