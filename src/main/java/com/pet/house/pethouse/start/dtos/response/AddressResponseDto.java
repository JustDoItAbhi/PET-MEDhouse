package com.pet.house.pethouse.start.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponseDto {
    private long id;
    private String country;
    private String city;
    private String street;
    private int houseNumber;
    private int postalCode;
    private String ownerName;
}
