package com.cxn.dao;

import com.cxn.model.User;

import java.util.List;

/**
 * @program: mybatis
 * @description: 验证mybatis动态代理实现接口的调用
 * @author: cxn
 * @create: 2018-04-19 15:06
 * @Version v1.0
 */
public interface UserMapper {

    User getById(Integer id);

    User getByName(String name);

    List<User> queryAll();

    void insertUser(User user);

    void updateUser(User user);

    void removeUser(Integer id);
}
