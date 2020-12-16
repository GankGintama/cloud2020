package com.lqh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CommonResult
 * @Description TODO
 * @Author 亦萧
 * @Date 2020/11/13 17:19
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>  {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code, message, null);
    }

}