package ua.mkorniie.entity;


import lombok.*;
import ua.mkorniie.entity.catalogue.Language;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by safety on 30.05.2019.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String passwordEncoded;
    private ArrayList<Role> roles;
    private String phone;
    private String email;
    private Language language;
}
