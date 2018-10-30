package com.shop;

import com.shop.dao.UserMapper;
import com.shop.po.UserExample;
import com.shop.pojo.User;
import com.shop.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created By Lizhengyuan on 18-10-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "com.shop.*")
public class TestMgtApplication {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){

        UserExample userExample = new UserExample();
        userExample.setOrderByClause("username asc");
        userExample.setDistinct(false); //去除重复,true是选择不重复记录,false反之
        UserExample.Criteria criteria = userExample.createCriteria(); //构造自定义查询条件
        criteria.andUsernameEqualTo("zhangsan");
        //自定义查询条件可能返回多条记录,使用List接收
        List<User> users = userMapper.selectByExample(userExample);
        System.out.println(users);
    }

    @Test
    public void test1(){
        //加密校验
        String passd = MD5Util.getMD5Res("admin123");
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo("admin");
        criteria.andPasswordEqualTo(passd);
        List<User> users = userMapper.selectByExample(userExample);
        System.out.println(users);
    }
}
