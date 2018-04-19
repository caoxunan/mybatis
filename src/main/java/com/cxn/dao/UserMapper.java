package com.cxn.dao;

import com.cxn.model.User;
import org.apache.ibatis.annotations.Param;

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

    List<User> getByName(@Param("name") String name);

    List<User> queryAll();

    void insertUser(User user);

    void updateUser(User user);

    void removeUser(Integer id);

    List<User> queryAllUserBySort(@Param("orderType") Integer orderType);

    List<User> queryUserByNameAndAge(@Param("name") String name, @Param("age") Integer age);

    List<User> queryUserByIds(@Param("ids") List<Integer> ids);
}
