package com.huanyu.es1.controller;

import com.huanyu.es1.dao.ItemEsDao;
import com.huanyu.es1.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sunsf
 * @date: 2020/3/14 15:17
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ItemEsDao userEsDao;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    /**
     * 创建索引
     * @param 
     * @return: 
     * @author: sunsf
     * @date:   2020/3/15 21:38
     */
    @RequestMapping("/create")
    public void newIndex(){
        // 创建索引，会根据Item类的@Document注解信息来创建
        elasticsearchTemplate.createIndex(Item.class);
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        elasticsearchTemplate.putMapping(Item.class);
    }
    /**
     *  删除索引库
     * @param
     * @return:
     * @author: sunsf
     * @date:   2020/3/15 21:38
     */
    @RequestMapping("/delete")
    public void delete(){
        // 创建索引，会根据Item类的@Document注解信息来创建
        elasticsearchTemplate.createIndex(Item.class);
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        elasticsearchTemplate.deleteIndex("index");
    }

    
}
