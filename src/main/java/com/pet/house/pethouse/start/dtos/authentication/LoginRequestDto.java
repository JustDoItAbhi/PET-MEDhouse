package com.pet.house.pethouse.start.dtos.authentication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    private String ownerEmail;
    private String password;
}
