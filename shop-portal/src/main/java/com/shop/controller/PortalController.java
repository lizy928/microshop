package com.shop.controller;

import com.shop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Lizhengyuan on 18-11-1
 */
@RestController
@RequestMapping("portal")
public class PortalController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("getSortMenuList")
    public Object getSortMenuList(){

        return itemCatService.getSortMenuList();
    }


}
