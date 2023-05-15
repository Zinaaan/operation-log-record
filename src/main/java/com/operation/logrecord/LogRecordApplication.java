package com.operation.logrecord;

import com.operation.logrecord.Entity.SaveOrder;
import com.operation.logrecord.Entity.UpdateOrder;
import com.operation.logrecord.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogRecordApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(LogRecordApplication.class, args);
    }

    @Override
    public void run(String... args) {
        SaveOrder saveOrder = new SaveOrder();
        saveOrder.setId(1L);
        orderService.saveOrder(saveOrder);

        UpdateOrder updateOrder = new UpdateOrder();
        updateOrder.setOrderId(2L);
        orderService.updateOrder(updateOrder);
    }
}
