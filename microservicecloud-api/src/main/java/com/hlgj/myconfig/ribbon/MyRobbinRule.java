/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MyRobbinRule
 * Author:   Nathan
 * Date:     2020/4/9 10:40
 * Description: MyRobbinRule
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.myconfig.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈MyRobbinRule〉
 * 自定义ribbon 的访问算法，默认是轮询
 * @author Nathan
 * @create 2020/4/9
 * @since 1.0.0
 */
@Configuration
public class MyRobbinRule {

    @Bean
    public IRule myRobbinRule(){
        return new RandomRule();//如果不定义的话， ribbon默认走轮询，现在指定为随机
    }
}