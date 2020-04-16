/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SpringConfigApplication
 * Author:   Nathan
 * Date:     2020/4/16 17:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Nathan
 * @create 2020/4/16
 * @since 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigServer
public class SpringConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigApplication.class, args);
    }
}