package org.example.practice.model;


import lombok.*;
import lombok.Data;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Support {
    private String url;
    private String text;
}
