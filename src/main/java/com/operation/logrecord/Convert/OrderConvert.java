package com.operation.logrecord.Convert;

import com.operation.logrecord.Entity.OperateLog;

/**
 * @author lzn
 * @date 2023/03/26 17:58
 * @description The convert interface of order
 */
public interface OrderConvert<PARAM> {

    /**
     * Convert the param to the uniformed log data structures
     *
     * @param param Any order entities
     * @return The packaged operation log object
     */
    OperateLog convert(PARAM param);
}
