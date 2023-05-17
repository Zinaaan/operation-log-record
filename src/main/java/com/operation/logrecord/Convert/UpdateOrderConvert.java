package com.operation.logrecord.Convert;

import com.operation.logrecord.Entity.OperateLog;
import com.operation.logrecord.Entity.UpdateOrder;

/**
 * @author lzn
 * @date 2023/03/26 18:01
 * @description
 */
public class UpdateOrderConvert implements OrderConvert<UpdateOrder>{

    @Override
    public OperateLog convert(UpdateOrder updateOrder) {
        OperateLog operateLog = new OperateLog();
        operateLog.setOrderId(updateOrder.getOrderId());
        return operateLog;
    }
}
