package com.shop.service.impl;

import com.shop.dao.ItemCatDao;
import com.shop.pojo.CatNode;
import com.shop.pojo.ItemCat;
import com.shop.service.ItemCatService;
import com.shop.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李正元
 * @create 2018-11-02 0:11
 * @desc
 **/
@Service
public class ItemServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatDao itemCatDao;

    @Override
    public Object getSortMenuList() {
        //查询分类列表
        //catResult.setData(getCatList(0));
        //return catResult;
        List<ItemCat> list = itemCatDao.itemCatList();
        //一级目录数据
       // List<ItemCat> itemCatParentList = list.stream().filter(e -> e.getParentId() == 0).sorted(Comparator.comparing(ItemCat::getId)).collect(Collectors.toList());

        List<ItemCat> rootList = new ArrayList<>();
        List<ItemCat> nextList = new ArrayList<>();
        List<ItemCat> childList = new ArrayList<>();

        list.forEach( e -> {
            if(e.getIsParent()){
                if(e.getParentId() == 0){
                    rootList.add(e);
                }else {
                    nextList.add(e);
                }
            }else {
                childList.add(e);
            }
        });
        List<ItemCat> parentList = new ArrayList<>();
        if(rootList.size() > 14){
            parentList = rootList.subList(0,14);
        }
        List<CatNode> catNodes = new ArrayList<>();
        parentList.forEach( parentNode -> {
            CatNode catNode = new CatNode();
            List<CatNode> parentItem = new ArrayList<>();
            catNode.setName(parentNode.getName());
            catNode.setUrl("/getItemByCat?itemCatId="+parentNode.getId());
            nextList.forEach( next ->{
                if(parentNode.getId() == next.getParentId()){
                    CatNode nextNode = new CatNode();
                    nextNode.setName(next.getName());
                    nextNode.setUrl("/getItemByCat?itemCatId="+next.getId());
                    List<String> childItem = new ArrayList<>();
                    childList.forEach( child -> {
                        if(next.getId() == child.getParentId()){
                            childItem.add("/getItemByCat?itemCatId="+child.getId());
                        }
                    });
                    nextNode.setItem(childItem);
                    parentItem.add(nextNode);
                }
            });
            catNode.setItem(parentItem);
            catNodes.add(catNode);
        });
        return JsonUtils.toJson(catNodes);
    }



    private List<?> getCatList(long parentId) {
        List<ItemCat> list = itemCatDao.itemCatList();//返回值list
        List resultList = new ArrayList<>();
        //向list中添加节点
        int count = 0;
        for (ItemCat tbItemCat : list) {
            //判断是否为父节点
            if (tbItemCat.getIsParent()) {
                CatNode catNode = new CatNode();
                if (parentId == 0) {
                    catNode.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
                } else {
                    catNode.setName(tbItemCat.getName());
                }
                catNode.setUrl("/products/"+tbItemCat.getId()+".html");
                catNode.setItem(getCatList(tbItemCat.getId()));

                resultList.add(catNode);
                count ++;
                //第一层只取14条记录
                if (parentId == 0 && count >=14) {
                    break;
                }
                //如果是叶子节点
            } else {
                resultList.add("/products/"+tbItemCat.getId()+".html|" + tbItemCat.getName());
            }
        }
        return resultList;
    }
}
