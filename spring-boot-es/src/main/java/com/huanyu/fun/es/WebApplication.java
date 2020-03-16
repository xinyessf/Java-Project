package com.huanyu.fun.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author: sunsf
 * @date: 2020/3/14 14:58
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableElasticsearchRepositories(basePackages = "com.huanyu.fun.es.dao")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
