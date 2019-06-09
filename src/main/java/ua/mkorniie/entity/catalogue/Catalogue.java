package ua.mkorniie.entity.catalogue;


/**
 * Created by safety on 30.05.2019.
 */

import lombok.*;

/**
 * @// TODO: 30.05.2019 Make price-issues map? Separate class? wtf?
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Catalogue {
    private Long id;
    private String index;
    private String title;
    private String cover;
    private Language language;
    private Publisher publisher;
}
