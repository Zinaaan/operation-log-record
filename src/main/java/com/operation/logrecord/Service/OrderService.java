package com.operation.logrecord.Service;

import com.operation.logrecord.Annotations.RecordOperate;
import com.operation.logrecord.Convert.SaveOrderConvert;
import com.operation.logrecord.Convert.UpdateOrderConvert;
import com.operation.logrecord.Entity.SaveOrder;
import com.operation.logrecord.Entity.UpdateOrder;
import org.springframework.stereotype.Service;

/**
 * @author lzn
 * @date 2023/03/26 17:32
 * @Description
 */
@Service
public class OrderService {

    @RecordOperate(desc = "保存订单", convert = SaveOrderConvert.class)
    public boolean saveOrder(SaveOrder saveOrder){
        System.out.println("save order, orderId: " + saveOrder.getId());
        return true;
    }

    @RecordOperate(desc = "更新订单", convert = UpdateOrderConvert.class)
    public boolean updateOrder(UpdateOrder updateOrder){
        System.out.println("update order, orderId: " + updateOrder.getOrderId());
        return true;
    }
}
