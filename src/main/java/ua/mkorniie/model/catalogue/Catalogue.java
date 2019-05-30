package ua.mkorniie.model.catalogue;

import ua.mkorniie.model.catalogue.price.Price;

/**
 * Created by safety on 30.05.2019.
 */

/**
 * @// TODO: 30.05.2019 Make price-issues map? Separate class? wtf?
 */
public class Catalogue {
    private Long id;
    private String title;
    private String publisher;
    private Language language;
    private Integer issuesPerWeek;
    private Price prices;
}
