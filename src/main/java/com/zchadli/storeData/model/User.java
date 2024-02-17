package com.zchadli.storeData.model;

import lombok.Data;
@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String gender;
    private String birthDate;
    private String image;
}
