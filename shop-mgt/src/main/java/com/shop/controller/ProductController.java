package com.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李正元
 * @create 2018-10-31 0:32
 * @desc
 **/
@RestController
@RequestMapping("product")
public class ProductController extends BaseController{

    @RequestMapping("listProduct")
    public Object listProduct(){


        return null;
    }

}
