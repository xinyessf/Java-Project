package com.huanyu.fun.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author: sunsf
 * @date: 2020/3/18 13:50
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableElasticsearchRepositories(basePackages = "com.huanyu.fun.crawler")
public class CrawlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrawlerApplication.class, args);
    }

}
