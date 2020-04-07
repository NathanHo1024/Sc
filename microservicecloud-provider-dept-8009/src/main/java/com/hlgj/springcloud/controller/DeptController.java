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
import com.hlgj.springcloud.Dept;
import com.hlgj.springcloud.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/add")
    public JSONObject addDept(@RequestBody Dept dept){
        JSONObject jsonObject = new JSONObject();
        if(deptService.addDept(dept)){
            jsonObject.put("添加部门", "成功");
        }else {
            jsonObject.put("添加部门", "失败");
        }
        return jsonObject;
    }

    @PostMapping("/selectById")
    public JSONObject selectById(@RequestParam Integer id){
        JSONObject jsonObject = new JSONObject();
        Dept dept = deptService.selectDeptById(id);
        jsonObject.put("查询结果", dept);
        return jsonObject;
    }

    @RequestMapping(value = "/selectAllDept",method = RequestMethod.GET)
    public JSONObject selectAllDept(){
        JSONObject jsonObject = new JSONObject();
        List<Dept> deptList = deptService.selectAllDept();
        jsonObject.put("查询结果", deptList);
        return jsonObject;
    }
}