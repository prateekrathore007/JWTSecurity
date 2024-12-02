package com.spring_security.security.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {

    private String name;
    private String color;
    private String size;

}
