package ua.mkorniie.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by safety on 30.05.2019.
 */
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "names")
public class Name {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="given_name")
    private String givenName;

    @Column(name="family_name")
    private String familyName;

    @Column(name="full_name")
    private String fullName;
}
