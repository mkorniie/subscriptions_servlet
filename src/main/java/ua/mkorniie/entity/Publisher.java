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
}
