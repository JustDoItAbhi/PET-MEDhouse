package com.pet.house.pethouse.start.dtos.authentication;

import com.pet.house.pethouse.start.dtos.requestdtos.AddressRequestDto;
import com.pet.house.pethouse.start.entity.owner_pet.owner.RoleType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Signup {
    private String ownerName;
    private String ownerEmail;
    private String password;
    private String phoneNumber;
    private List<String>roles;
    private List<AddressRequestDto> addressesList;
}
