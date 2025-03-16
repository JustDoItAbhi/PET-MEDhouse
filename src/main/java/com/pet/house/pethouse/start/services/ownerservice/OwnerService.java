package com.pet.house.pethouse.start.services.ownerservice;

import com.pet.house.pethouse.start.dtos.authentication.LoginRequestDto;
import com.pet.house.pethouse.start.dtos.authentication.Signup;
import com.pet.house.pethouse.start.dtos.requestdtos.OwnerRequestDto;
import com.pet.house.pethouse.start.dtos.response.OwnerResponseDto;

public interface OwnerService {
    OwnerResponseDto createOwner(OwnerRequestDto dto);
    OwnerResponseDto signup(Signup dto);
    OwnerResponseDto login(LoginRequestDto dto);
    OwnerResponseDto getByEmail(String email);
    OwnerResponseDto getOwnerById(long id);

}
