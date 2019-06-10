package ua.mkorniie.entity.catalogue;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Publisher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String country;
}
