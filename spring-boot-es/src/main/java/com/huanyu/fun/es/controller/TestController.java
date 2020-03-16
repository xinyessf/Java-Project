package com.huanyu.fun.es.controller;

import com.google.common.collect.Lists;
import com.huanyu.fun.es.dao.ItemEsDao;
import com.huanyu.fun.es.entity.Item;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
