package ua.mkorniie.entity.catalogue;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Publisher {
    private Long id;
    private String name;
    private String country;
}
