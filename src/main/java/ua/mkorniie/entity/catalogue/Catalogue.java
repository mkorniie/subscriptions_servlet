package ua.mkorniie.entity.catalogue;

import ua.mkorniie.entity.catalogue.price.Price;

import java.security.PublicKey;

/**
 * Created by safety on 30.05.2019.
 */

/**
 * @// TODO: 30.05.2019 Make price-issues map? Separate class? wtf?
 */
public class Catalogue {
    private Long id;
    private String index;
    private String title;
    private String cover;
    private Language language;
    private Publisher publisher;
}
