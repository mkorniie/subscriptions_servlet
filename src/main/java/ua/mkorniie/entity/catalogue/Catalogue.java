package ua.mkorniie.entity.catalogue;


/**
 * Created by safety on 30.05.2019.
 */

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @// TODO: 30.05.2019 Make price-issues map? Separate class? wtf?
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Catalogue {
    @Id
    @GeneratedValue
    private Long id;
    private String index;
    private String title;
    private String cover;
    private Language language;
    private Publisher publisher;
}
