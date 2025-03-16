package com.pet.house.pethouse.start.dtos.requestdtos;


import com.pet.house.pethouse.start.dtos.authentication.RoleRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VetRequestDto {
    private String vetName;
    private List<String> role;
    private String specialityName;
    private String discription;
    private String email;
    private String password;
}
