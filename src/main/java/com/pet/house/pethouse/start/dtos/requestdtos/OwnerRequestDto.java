package com.pet.house.pethouse.start.dtos.requestdtos;

import com.pet.house.pethouse.start.dtos.authentication.RoleRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OwnerRequestDto {
    private List<RoleRequestDto> role;
    private String ownerName;
    private String ownerEmail;
    private String password;
    private String phoneNumber;
    private List<AddressRequestDto> addressesList;
    private List<PetRequestDto>petRequestDtos;
    private List<AppointmentRequestDto>appointmentsList;
}
