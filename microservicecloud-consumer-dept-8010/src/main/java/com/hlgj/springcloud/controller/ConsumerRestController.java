/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: RestController
 * Author:   Nathan
 * Date:     2020/4/7 15:01
 * Description: Rest
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.springcloud.controller;

import com.hlgj.springcloud.ReturnResult;
import com.hlgj.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Rest〉
 * 使用restTemplate访问restful接口
 * (url,requestMap,ResponseBean.class)这三个参数分别代表
 * Rest请求地址，请求参数，Http响应转换被转换的对象类型。
 * @author Nathan
 * @create 2020/4/7
 * @since 1.0.0
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerRestController {

    @Autowired
    private RestTemplate restTemplate;

//    private static final String URL = "http://127.0.0.1:8009/dept";
    private static final String URL = "http://MICROSERVICECLOUD-DEPT";

    @PostMapping("/add")
    public ResponseEntity<ReturnResult> addDept(@RequestBody Dept dept){
        return  restTemplate.postForEntity(URL + "/dept" + "/add", dept, ReturnResult.class);
    }

    @GetMapping("/add/{id}")
    public ResponseEntity<ReturnResult> getDept(@PathVariable Integer id){
        return restTemplate.getForEntity(URL + "/dept" + "/selectById/" + id,ReturnResult.class);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ReturnResult> getALl(){
        return restTemplate.getForEntity(URL + "/dept" + "/selectAllDept", ReturnResult.class);
    }

    //测试@EnableDiscoveryClient，消费端可以调用服务发现
    @GetMapping("/discovery")
    public ResponseEntity<ReturnResult> consumerDiscovery(){
        return restTemplate.getForEntity(URL + "/dept" + "/discovery", ReturnResult.class);
    }
}