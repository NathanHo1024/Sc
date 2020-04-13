/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DeptClientServiceFallbackFactory
 * Author:   Nathan
 * Date:     2020/4/13 15:46
 * Description: 熔断处理机制
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.springcloud.clientservice;

import com.hlgj.springcloud.ReturnResult;
import com.hlgj.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈熔断处理机制〉
 * 该实现类FallbackFactory<T> -- 泛型声明为需要做熔断处理的接口类。
 * @author Nathan
 * @create 2020/4/13
 * @since 1.0.0
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public ReturnResult getbyId(Integer id) {
                return new ReturnResult().setMsg("服务器异常").setCode(300);
            }

            @Override
            public ReturnResult getAll() {
                return null;
            }

            @Override
            public ReturnResult addDept(Dept dept) {
                return null;
            }
        };
    }
}
