package ua.mkorniie.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Getter
public class User implements ReflectionableEntity {
    private Integer id;
    private String fullName;
    private String passwordEncoded;
    private Roles role;
    private String phone;
    private String email;
    private Language language;

    public User(String fullName, String passwordEncoded, Roles role, String phone, String email, Language language) {
        this.fullName = fullName;
        this.passwordEncoded = passwordEncoded;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.language = language;
    }

//    public void setRole(String name) {
//        this.role = Roles.valueOf(name);
//    }
//
//    public void setLanguage(String name) {
//        this.language = Language.valueOf(name);
//    }

    public HashMap<String, String> getStringValues() {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id.toString());
        map.put("fullName", fullName);
        map.put("passwordEncoded", passwordEncoded);
        map.put("phone", phone);
        map.put("email", email);
        map.put("role", role.toString());
        map.put("language", language.toString());

        return map;
    }
}