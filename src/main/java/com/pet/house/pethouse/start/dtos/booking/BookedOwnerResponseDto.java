package com.pet.house.pethouse.start.dtos.booking;

import com.pet.house.pethouse.start.dtos.authentication.RoleResponseDto;
import com.pet.house.pethouse.start.dtos.response.AddressResponseDto;
import com.pet.house.pethouse.start.dtos.response.AppointmentsResponseDto;
import com.pet.house.pethouse.start.dtos.response.PetResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookedOwnerResponseDto {
    private long id;
    private String ownerName;
    private String ownerEmail;
    private String phoneNumber;
    private List<AddressResponseDto> addressesList;
}
