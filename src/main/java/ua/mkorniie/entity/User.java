package ua.mkorniie.entity;


import lombok.*;

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
//    private Name fullName;
//    private String passwordEncoded;
//    private ArrayList<Role> roles;
//    private String deliveryAddress;
//    private String phone;
    private String email;

    // to delete!
    private String name;
    private String country;

    public User(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }
}
