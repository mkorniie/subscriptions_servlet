package ua.mkorniie.entity;

import java.util.Date;

/**
 * Created by safety on 30.05.2019.
 */
public class Order {
    private Long id;
    private final Date orderDate = new Date();
    private Long userId;
    private Long catalogueId;
    private boolean status;
    private Integer sum;
    private Integer periodInMonths;
}
