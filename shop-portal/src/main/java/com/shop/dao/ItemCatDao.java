package com.shop.dao;

import com.shop.pojo.ItemCat;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 李正元
 * @create 2018-11-02 0:08
 * @desc
 **/
@Mapper
public interface ItemCatDao {

    List<ItemCat> itemCatList();
}
