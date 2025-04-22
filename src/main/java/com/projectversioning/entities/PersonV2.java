package com.projectversioning.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonV2 {

    private Name name;    // Name as an object with first and last name
    private int age;      // Age
    private String address; // Address
    private String email;  // Email
}
