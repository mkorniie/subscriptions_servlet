package ua.mkorniie.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by safety on 30.05.2019.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private final Date orderDate = new Date();
    private Long userId;
    private Long catalogueId;
    private boolean status;
    private Integer sum;
    private Integer periodInMonths;
}
