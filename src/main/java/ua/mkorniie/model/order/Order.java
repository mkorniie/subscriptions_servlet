package ua.mkorniie.model.order;

import ua.mkorniie.model.order.paymode.PayMode;

import java.util.Date;

/**
 * Created by safety on 30.05.2019.
 */
public class Order {
    private Long id;
    private Long userId;
    private Long catalogueId;
    private final Date orderDate = new Date();;
    private OrderStatus status;
    private PayMode payMode;
}
