package ua.mkorniie.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by safety on 30.05.2019.
 */
@AllArgsConstructor
@Getter
@Setter
public class Name {
    private String givenName;
    private String familyName;
    private String fullName;
}
