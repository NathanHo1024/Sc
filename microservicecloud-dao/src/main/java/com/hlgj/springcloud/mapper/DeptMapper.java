/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DeptMapper
 * Author:   Nathan
 * Date:     2020/4/2 16:40
 * Description: DeptMapper
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.springcloud.mapper;

import com.hlgj.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 〈一句话功能简述〉<br>
 * 〈DeptMapper〉
 *
 * @author Nathan
 * @create 2020/4/2
 * @since 1.0.0
 */
@Mapper
public interface DeptMapper {
    /**
     * 插入部门信息
     * @param dept 部门信息
     * @return
     */
    int insert(Dept dept);

    /**
     * 通过id获取部门信息
     * @param id id
     * @return
     */
    Dept selectDeptById(Integer id);

    /**
     * 获取所有的部门信息
     * @return
     */
    List<Dept> selectAllDept();
}
