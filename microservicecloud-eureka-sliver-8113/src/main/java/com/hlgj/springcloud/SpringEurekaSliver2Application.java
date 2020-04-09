/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SpringEurekaApplication
 * Author:   Nathan
 * Date:     2020/4/7 15:26
 * Description: Eureka
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.hlgj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 〈一句话功能简述〉<br>
 * 〈Eureka〉
 *
 * @author Nathan
 * @create 2020/4/7
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringEurekaSliver2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaSliver2Application.class, args);
    }
}