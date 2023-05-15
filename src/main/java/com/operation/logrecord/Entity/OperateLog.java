package com.operation.logrecord.Entity;

/**
 * @author lzn
 * @date 2023/03/26 17:43
 * @Description
 */
public class OperateLog {

    private long orderId;

    private String desc;

    private String result;

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
