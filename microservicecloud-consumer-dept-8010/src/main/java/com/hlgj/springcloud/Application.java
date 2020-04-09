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

import com.hlgj.myconfig.ribbon.MyRobbinRuleUpdate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

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
/**
 * 参数 1：  在eureka上注册的服务名称
 * 参数 2：  自己定义的负载均衡算法配置
 */
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MyRobbinRuleUpdate.class)//添加该注解，在启动服务的时候，就能去加载自定义的Ribbon配置类，从而使配置生效。
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}