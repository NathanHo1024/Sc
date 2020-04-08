/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DeptController
 * Author:   Nathan
 * Date:     2020/4/2 15:35
 * Description: 部门controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.hlgj.springcloud.ReturnResult;
import com.hlgj.springcloud.entity.Dept;
import com.hlgj.springcloud.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈部门controller〉
 *
 * @author Nathan
 * @create 2020/4/2
 * @since 1.0.0
 */
@RestController//controller + RequestBody json返回
@RequestMapping("/dept")
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/add")
    public ReturnResult addDept(@RequestBody Dept dept){
        ReturnResult returnResult = new ReturnResult();
        JSONObject jsonObject = new JSONObject();
        if(deptService.addDept(dept)){
            jsonObject.put("添加部门", "成功");
            returnResult.setData(jsonObject).setCode(200).setMsg("添加部门");
        }else {
            jsonObject.put("添加部门", "失败");
            returnResult.setData(jsonObject).setCode(300).setMsg("添加部门");
        }
        return returnResult;
    }

    @GetMapping("/selectById/{id}")
    public ReturnResult selectById(@PathVariable Integer id){
        ReturnResult returnResult = new ReturnResult();
        JSONObject jsonObject = new JSONObject();
        Dept dept = deptService.selectDeptById(id);
        jsonObject.put("查询结果", dept);
        return returnResult.setMsg("查询结果").setCode(200).setData(jsonObject);
    }

    @RequestMapping(value = "/selectAllDept",method = RequestMethod.GET)
    public ReturnResult selectAllDept(){
        ReturnResult returnResult = new ReturnResult();
        JSONObject jsonObject = new JSONObject();
        List<Dept> deptList = deptService.selectAllDept();
        jsonObject.put("查询结果", deptList);
        return returnResult.setMsg("查询结果").setCode(200).setData(jsonObject);
    }

    @GetMapping("/discovery")
    public ReturnResult discovery(){
        ReturnResult returnResult = new ReturnResult();
        List<String> lists = discoveryClient.getServices();//获取注册的微服务的信息
        log.info("{}", lists);

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for(ServiceInstance serviceInstance : serviceInstances){
            log.info("Id:{},Host:{},Port:{},URI:{}", serviceInstance.getServiceId(),
                    serviceInstance.getHost(),serviceInstance.getPort()
            ,serviceInstance.getUri());
        }
        returnResult.setMsg("get");
        returnResult.setData(this.discoveryClient);
        returnResult.setCode(200);
        return returnResult;
    }
}