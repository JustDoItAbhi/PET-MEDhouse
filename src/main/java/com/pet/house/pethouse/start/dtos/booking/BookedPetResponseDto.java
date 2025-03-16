package com.pet.house.pethouse.start.dtos.booking;

import com.pet.house.pethouse.start.dtos.response.OwnerResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.owner.PetType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookedPetResponseDto {
    private long id;
    private String petName;
    private int age;
    private PetType petType;
    private String petBread;
    private String petProblems;
    private String petHistory;
}
