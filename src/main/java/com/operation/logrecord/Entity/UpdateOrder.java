package com.operation.logrecord.Entity;

/**
 * @author lzn
 * @date 2023/03/26 17:34
 * @description
 */
public class UpdateOrder {

    private long orderId;

    private String desc;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
