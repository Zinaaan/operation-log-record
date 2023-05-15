package com.operation.logrecord.Annotations;

import com.operation.logrecord.Convert.OrderConvert;

import java.lang.annotation.*;

/**
 * @author lzn
 * @date 2023/03/26 17:44
 * @Description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordOperate {

    //description of current method
    String desc() default "";

    Class<? extends OrderConvert> convert();
}
