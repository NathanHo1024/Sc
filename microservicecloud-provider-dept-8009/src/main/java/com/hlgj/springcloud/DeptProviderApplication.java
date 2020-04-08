/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DeptProviderApplication
 * Author:   Nathan
 * Date:     2020/4/2 15:44
 * Description: DeptApplication
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 〈一句话功能简述〉<br> 
 * 〈DeptApplication〉
 *
 * @author Nathan
 * @create 2020/4/2
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient//本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient//服务发现
@MapperScan(basePackages = {"com.hlgj.springcloud.mapper"})
public class DeptProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderApplication.class, args);
    }
}