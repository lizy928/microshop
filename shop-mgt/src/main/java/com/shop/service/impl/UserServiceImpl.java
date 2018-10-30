package com.shop.service.impl;

import com.shop.dao.AdminMapper;
import com.shop.dao.UserMapper;
import com.shop.po.AdminExample;
import com.shop.pojo.Admin;
import com.shop.service.UserService;
import com.shop.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By Lizhengyuan on 18-10-30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String userName, String passWord){
        //加密校验
        String passd = MD5Util.getMD5Res(passWord);
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameEqualTo(userName);
        criteria.andPasswordEqualTo(passd);
        List<Admin> users = adminMapper.selectByExample(adminExample);
        return users.isEmpty() ? null : users.get(0);
    }
}
