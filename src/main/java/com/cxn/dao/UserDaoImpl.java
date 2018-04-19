package com.cxn.dao;

import com.cxn.model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @program: mybatis
 * @description: ${description}
 * @author: cxn
 * @create: 2018-04-19 14:17
 * @Version v1.0
 */
public class UserDaoImpl implements UserDao {

    private SqlSession sqlSession;
    // 通过构造函数接收sqlsession
    public UserDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public User getById(Integer id) {
        return sqlSession.selectOne("namespace1.getById", id);
    }

    @Override
    public List<User> queryAll() {
        return sqlSession.selectList("namespace1.queryAll");
    }

    @Override
    public void insertUser(User user) {
        sqlSession.insert("namespace1.insertUser", user);
    }

    @Override
    public void updateUser(User user) {
        sqlSession.update("namespace1.updateUser", user);
    }

    @Override
    public void removeUser(Integer id) {
        sqlSession.delete("namespace1.removeUser", id);
    }

}
