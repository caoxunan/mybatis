package com.cxn.dao;

import com.cxn.model.User;
import org.omg.CORBA.INTERNAL;

import java.util.List;

/**
 * @program: mybatis
 * @description: ${description}
 * @author: cxn
 * @create: 2018-04-19 13:35
 * @Version v1.0
 */
public interface UserDao {

    User getById(Integer id);

    List<User> queryAll();

    void insertUser(User user);

    void updateUser(User user);

    void removeUser(Integer id);
}
