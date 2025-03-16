package com.pet.house.pethouse.start.services.roleservice;

import com.pet.house.pethouse.start.dtos.authentication.RoleRequestDto;
import com.pet.house.pethouse.start.dtos.authentication.RoleResponseDto;

public interface RoleServices {
    RoleResponseDto createRole(RoleRequestDto dto);
}
