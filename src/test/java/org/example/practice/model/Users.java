package org.example.practice.model;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;

    private List<Data> data;
    private Support support;
}
