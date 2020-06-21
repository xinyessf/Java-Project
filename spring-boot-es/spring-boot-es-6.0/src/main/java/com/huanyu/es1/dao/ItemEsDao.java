package com.huanyu.es1.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.huanyu.es1.entity.Item;

/**
 * @author: sunsf
 * @date: 2020/3/14 15:47
 */

public interface ItemEsDao extends ElasticsearchRepository<Item, Long> {
    //List<Item> findByPriceBetween(double price1, double price2);

}
