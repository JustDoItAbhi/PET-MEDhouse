package com.pet.house.pethouse.start.mappers;

import com.pet.house.pethouse.start.dtos.authentication.RoleResponseDto;
import com.pet.house.pethouse.start.dtos.booking.BookedVetResponseDto;
import com.pet.house.pethouse.start.dtos.response.VetResponseDto;

import com.pet.house.pethouse.start.entity.owner_pet.owner.Roles;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.Vets;

import java.util.ArrayList;
import java.util.List;

public class VetMapper {
    public static VetResponseDto fromEntity(Vets vets){

        VetResponseDto responseDto=new VetResponseDto();
        responseDto.setId(vets.getId());
        List<RoleResponseDto> roles=new ArrayList<>();
        for(Roles roles1: vets.getRolesList()){
            RoleResponseDto dto=new RoleResponseDto();
            dto.setRoles(roles1.getRole());
            roles.add(dto);
        }
        responseDto.setRoleResponseDtoList(roles);
        responseDto.setVetName(vets.getVetName());
        responseDto.setEmail(vets.getEmail());
        responseDto.setPassword(vets.getPassword());
        responseDto.setAppointmentsList(vets.getAppointmentsList());
        responseDto.setSpecility(vets.getSpecializationName());
        responseDto.setSpecilityDiscription(vets.getSpecilizationDiscription());
    return responseDto;
    }
    public static BookedVetResponseDto fromEntityForBooking(Vets vets){
        BookedVetResponseDto responseDto=new BookedVetResponseDto();
        responseDto.setId(vets.getId());
        responseDto.setVetName(vets.getVetName());
        responseDto.setEmail(vets.getEmail());
        responseDto.setSpecility(vets.getSpecializationName());
        responseDto.setSpecilityDiscription(vets.getSpecilizationDiscription());
        return responseDto;
    }
}
