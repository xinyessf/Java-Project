package com.huanyu.fun.es.dao;

import com.huanyu.fun.es.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author: sunsf
 * @date: 2020/3/14 15:47
 */

public interface ItemEsDao extends ElasticsearchRepository<Item, Long> {
    //List<Item> findByPriceBetween(double price1, double price2);

}
