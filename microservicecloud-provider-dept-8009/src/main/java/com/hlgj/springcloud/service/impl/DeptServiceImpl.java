/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DeptServiceImpl
 * Author:   Nathan
 * Date:     2020/4/2 15:30
 * Description: 服务实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.springcloud.service.impl;

import com.hlgj.springcloud.entity.Dept;
import com.hlgj.springcloud.mapper.DeptMapper;
import com.hlgj.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈服务实现〉
 *
 * @author Nathan
 * @create 2020/4/2
 * @since 1.0.0
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean addDept(Dept dept) {
        int num = deptMapper.insert(dept);
        if(num == 1){
            return true;
        }
        return false;
    }

    @Override
    public Dept selectDeptById(Integer id) {
        return deptMapper.selectDeptById(id);
    }

    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectAllDept();
    }
}