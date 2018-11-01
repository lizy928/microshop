package com.shop;

import com.shop.service.ItemCatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created By Lizhengyuan on 18-10-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPortalApplication {

    @Autowired
    private ItemCatService itemCatService;


    @Test
    public void test(){
        System.out.println(itemCatService.getSortMenuList());
    }

}
