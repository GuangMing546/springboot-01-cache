package com.gm.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一，搭建基本环境
 * 1.导入数据库文件，创建出department和employee表
 * 2.创建javabean来封装数据
 * 3.整合mybatis操作数据库
 *      a.搞一下数据源
 *      b.基于注解来搞mybatis--->创建相对应的mapper来操作数据库
 * 二，快速体验缓存
 *      步骤：
 *          1.开启基于注解的缓存
 *          2.标注款村注解即可
 */
@MapperScan("com.gm.cache.mapper")
@SpringBootApplication
@EnableCaching
public class Springboot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01CacheApplication.class, args);
    }

}
