package com.operation.logrecord.Convert;

import com.operation.logrecord.Entity.OperateLog;
import com.operation.logrecord.Entity.SaveOrder;

/**
 * @author lzn
 * @date 2023/03/26 18:00
 * @Description
 */
public class SaveOrderConvert implements OrderConvert<SaveOrder>{

    @Override
    public OperateLog convert(SaveOrder saveOrder) {
        OperateLog operateLog = new OperateLog();
        operateLog.setOrderId(saveOrder.getId());
        return operateLog;
    }
}
