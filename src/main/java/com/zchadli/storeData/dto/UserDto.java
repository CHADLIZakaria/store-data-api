package com.zchadli.storeData.dto;

import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String sex;
    private String birthDate;
    private String imagePath;
    private Set<RoleDto> roles = new HashSet<>();
}
