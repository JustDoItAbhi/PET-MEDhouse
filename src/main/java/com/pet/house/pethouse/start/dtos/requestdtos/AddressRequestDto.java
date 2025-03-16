package com.pet.house.pethouse.start.dtos.requestdtos;

import com.pet.house.pethouse.start.dtos.response.OwnerResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequestDto {
    private String country;
    private String city;
    private String street;
    private int houseNumber;
    private int postalCode;
    private OwnerResponseDto ownerResponseDto;
}
