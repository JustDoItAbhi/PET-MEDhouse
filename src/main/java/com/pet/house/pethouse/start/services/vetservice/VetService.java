package com.pet.house.pethouse.start.services.vetservice;

import com.pet.house.pethouse.start.dtos.authentication.VetLoginDTO;
import com.pet.house.pethouse.start.dtos.requestdtos.VetRequestDto;
import com.pet.house.pethouse.start.dtos.response.VetResponseDto;

public interface VetService {
    VetResponseDto vetSignup(VetRequestDto dto);
    VetResponseDto vetLogin(VetLoginDTO dto);
}
