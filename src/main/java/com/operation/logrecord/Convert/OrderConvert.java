package com.operation.logrecord.Convert;

import com.operation.logrecord.Entity.OperateLog;

/**
 * @author lzn
 * @date 2023/03/26 17:58
 * @Description
 */
public interface OrderConvert<PARAM> {

    OperateLog convert(PARAM param);
}
