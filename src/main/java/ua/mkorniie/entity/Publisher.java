package ua.mkorniie.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Getter
public class Publisher {
    private Integer id;
    private String name;
    private String country;
    private String description;


    public Publisher(String name, String country, String description) {
        this.name = name;
        this.country = country;
        this.description = description;
    }
}
