/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Dept
 * Author:   Nathan
 * Date:     2020/4/2 14:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.springcloud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Nathan
 * @create 2020/4/2
 * @since 1.0.0
 */
@Data//get和set
@ToString
@AllArgsConstructor//全参构造
@NoArgsConstructor//空参构造
@Accessors(chain = true)//可以在一条语句设置多个参数
public class Dept implements Serializable {

    private static final long serialVersionUID = 4925079471136384193L;
    private Integer id;//主键

    private String deptName;//部门名称

    private String dbSource;//来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
}