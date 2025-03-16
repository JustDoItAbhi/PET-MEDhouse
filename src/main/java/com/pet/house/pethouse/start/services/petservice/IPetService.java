package com.pet.house.pethouse.start.services.petservice;

import com.pet.house.pethouse.start.dtos.requestdtos.PetRequestDto;
import com.pet.house.pethouse.start.dtos.response.PetResponseDto;

public interface IPetService {
    PetResponseDto createPetInfromation(PetRequestDto dto);
    PetResponseDto getOwnerById(long id);
}
