package org.example.practice.model;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Data {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
