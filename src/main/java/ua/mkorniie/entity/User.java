package ua.mkorniie.entity;


import lombok.*;
import ua.mkorniie.entity.catalogue.Language;

import java.util.ArrayList;

/**
 * Created by safety on 30.05.2019.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String fullName;
    private String passwordEncoded;
    private ArrayList<Role> roles;
    private String phone;
    private String email;
    private Language language;
}
