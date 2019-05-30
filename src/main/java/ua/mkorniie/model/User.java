package ua.mkorniie.model;

import java.util.ArrayList;

/**
 * Created by safety on 30.05.2019.
 */
public class User {
    private Long id;
    private Name fullName;
    private String passwordEncoded;
    private ArrayList<Role> roles;
    private String deliveryAddress;
    private String phone;
    private String email;
}
