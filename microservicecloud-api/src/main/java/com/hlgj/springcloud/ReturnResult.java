/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ReturnResult
 * Author:   Nathan
 * Date:     2020/4/7 15:03
 * Description: Return
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

/**
 * 〈一句话功能简述〉<br> 
 * 〈Return〉
 *
 * @author Nathan
 * @create 2020/4/7
 * @since 1.0.0
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ReturnResult {

    private Integer code;

    private String msg;

    private Object data;
}