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
 * 〈一句话功能简述〉<br> 
 * 〈DeptService〉
 * Feign的rest请求接口
 * @author Nathan
 * @create 2020/4/9
 * @since 1.0.0
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT")//声明注解，value为请求路径
@RequestMapping("/dept")
public interface DeptClientService {

    @GetMapping("/selectById/{id}")
    public ReturnResult getbyId(@PathVariable(name = "id") Integer id);

    @GetMapping(value = "/selectAllDept")
    public ReturnResult getAll();

    @PostMapping("/add")
    public ReturnResult addDept(@RequestBody Dept dept);
}