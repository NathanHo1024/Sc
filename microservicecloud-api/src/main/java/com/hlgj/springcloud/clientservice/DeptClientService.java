/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DeptService
 * Author:   Nathan
 * Date:     2020/4/9 16:07
 * Description: DeptService
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.springcloud.clientservice;

import com.hlgj.springcloud.ReturnResult;
import com.hlgj.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉
 * 根据已经绑定了Feign服务的DeptClientService 新建一个 熔断处理机制的实现类：
 * 该类需要实现FallbackFactory接口
 * <br>
 * 〈DeptService〉
 *  Feign的rest请求接口
 * @author Nathan
 * @create 2020/4/9
 * @since 1.0.0
 */
//声明注解，value为请求路径 fallbackFactory为降级熔断处理
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
@RequestMapping("/dept")
public interface DeptClientService {

    @GetMapping("/selectById/{id}")
    public ReturnResult getbyId(@PathVariable(name = "id") Integer id);

    @GetMapping(value = "/selectAllDept")
    public ReturnResult getAll();

    @PostMapping("/add")
    public ReturnResult addDept(@RequestBody Dept dept);
}