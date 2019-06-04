package ua.mkorniie.entity.catalogue.price;

import java.util.Date;

/**
 * Created by safety on 30.05.2019.
 */
public interface Assignable {
    void determinePrice();
    void determinePrice(Integer numberOfIssues);
    void determinePrice(Date endDate);
    void determinePrice(Date startDate, Date endDate);
}
