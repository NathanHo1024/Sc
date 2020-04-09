/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: BeanConfig
 * Author:   Nathan
 * Date:     2020/4/7 14:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Nathan
 * @create 2020/4/7
 * @since 1.0.0
 */
@Configuration//这个相当于 springmvc中的Application.xml文件
public class BeanConfig {

    @Bean
    @LoadBalanced//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端+负载均衡的工具
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean//显示指定算法
    public IRule myRule(){
        return new RandomRule();//这个方法为的就是指定负载均衡算法，----使用我们的自己想要用的替代默认的轮询,这里使用的是随机算法替换轮询
    }
}
//application.xml = @Configuration
//<bean id="RestTemplate" class="org.springframework.web.client.RestTemplate"/>
//bean = @Bean ,id=返回类型RestTemplate   class=new RestTemplate();