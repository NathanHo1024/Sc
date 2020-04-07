/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DeptService
 * Author:   Nathan
 * Date:     2020/4/2 15:30
 * Description: 部门服务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.springcloud.service;

import com.hlgj.springcloud.Dept;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈部门服务〉
 *
 * @author Nathan
 * @create 2020/4/2
 * @since 1.0.0
 */
public interface DeptService {

    boolean addDept(Dept dept);

    Dept selectDeptById(Integer id);

    List<Dept> selectAllDept();
}