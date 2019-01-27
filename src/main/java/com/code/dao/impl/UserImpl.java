package com.code.dao.impl;

import com.code.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Huangtian
 * @create 2019-01-25 22:24
 */
public class UserImpl {
    @Test
    public void getUserList() throws IOException {
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        InputStream ins = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = sfb.build(ins);
        SqlSession ss = ssf.openSession();
        List<User> userList = ss.selectList("com.code.dao.impl.UserImpl.getUserList");
        for (User user:userList){
            System.out.println(user);
        }

    }
    @Test
    public void getUserList2() throws IOException {
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        InputStream ins = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = sfb.build(ins);
        SqlSession ss = ssf.openSession();
        List<Map<String,Object>> userList = ss.selectList("com.code.dao.impl.UserImpl.getUserList2");
        for (Map map:userList){
            System.out.println(map);
        }

    }
    @Test
    public void getUserById() throws IOException {
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        InputStream ins = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = sfb.build(ins);
        SqlSession ss = ssf.openSession();
        Map<String,Object> userMap = ss.selectOne("com.code.dao.impl.UserImpl.getUserById", 2);
        System.out.println(userMap);
    }
    @Test
    public void getUserCondition() throws IOException {
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        InputStream ins = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = sfb.build(ins);
        SqlSession ss = ssf.openSession();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("age",15);
        paramMap.put("name","张三");
        Map<String,Object> userMap = ss.selectOne("com.code.dao.impl.UserImpl.getUserCondition", paramMap);
        System.out.println(userMap);
    }
    @Test
    public void getUserCondition2() throws IOException {
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        InputStream ins = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = sfb.build(ins);
        SqlSession ss = ssf.openSession();
        User user = new User();
        user.setAge(15);
        user.setGender(0);
        User userMap = ss.selectOne("com.code.dao.impl.UserImpl.getUserCondition2", user);
        System.out.println(userMap);
    }
}
