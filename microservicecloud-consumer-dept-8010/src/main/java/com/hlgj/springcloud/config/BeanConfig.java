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
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
//application.xml = @Configuration
//<bean id="RestTemplate" class="org.springframework.web.client.RestTemplate"/>
//bean = @Bean ,id=返回类型RestTemplate   class=new RestTemplate();