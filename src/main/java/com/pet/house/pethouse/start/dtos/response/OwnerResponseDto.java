package com.pet.house.pethouse.start.dtos.response;

import com.pet.house.pethouse.start.dtos.authentication.RoleResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Roles;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OwnerResponseDto {
    private long id;
    private String ownerName;
    private String ownerEmail;
    private String password;
    private String phoneNumber;
    private List<AddressResponseDto> addressesList;
    private List<RoleResponseDto>rolesList;
    private List<PetResponseDto>petResponseDtos;
    private List<AppointmentsResponseDto>appointmentsResponseDtoList;
}
