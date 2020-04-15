/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ZuulApplication
 * Author:   Nathan
 * Date:     2020/4/15 14:58
 * Description: Zuul
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Zuul〉
 *
 * @author Nathan
 * @create 2020/4/15
 * @since 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableZuulProxy//开去Zuul代理
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}