/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Application
 * Author:   Nathan
 * Date:     2020/4/7 15:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Nathan
 * @create 2020/4/7
 * @since 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient//声明注册服务，消费端
@EnableFeignClients(basePackages = {"com.hlgj.springcloud.clientservice"})//Feign接口所在的包
public class AppFeignlication {

    public static void main(String[] args) {
        SpringApplication.run(AppFeignlication.class, args);
    }
}