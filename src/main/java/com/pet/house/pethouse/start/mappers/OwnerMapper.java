package com.pet.house.pethouse.start.mappers;

import com.pet.house.pethouse.start.dtos.authentication.RoleResponseDto;
import com.pet.house.pethouse.start.dtos.response.*;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Addresses;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Owner;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Pets;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Roles;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.Appointments;

import java.util.ArrayList;
import java.util.List;

public class OwnerMapper {
    public static OwnerResponseDto fromEntity(Owner owner){
        OwnerResponseDto responseDto=new OwnerResponseDto();
        responseDto.setId(owner.getId());
        responseDto.setOwnerEmail(owner.getEmail());
        responseDto.setPassword(owner.getPassword());
        responseDto.setOwnerName(owner.getOwnerName());


        List<AddressResponseDto>addressResponseDtoList=new ArrayList<>();
        for(Addresses addresses: owner.getAddressesList()){
            AddressResponseDto dto=new AddressResponseDto();
            dto.setId(addresses.getId());
            dto.setCity(addresses.getCity());
            dto.setCountry(addresses.getCountry());
            dto.setStreet(addresses.getStreet());
            dto.setHouseNumber(addresses.getHouseNumber());
            dto.setPostalCode(addresses.getPostalCode());
            dto.setOwnerName(responseDto.getOwnerName());
            addressResponseDtoList.add(dto);
        }
        responseDto.setAddressesList(addressResponseDtoList);

        List<PetResponseDto>petResponseDtos=new ArrayList<>();
        for(Pets pets: owner.getPetsList()){
            PetResponseDto dto=new PetResponseDto();
            dto.setId(pets.getId());
            dto.setPetName(pets.getPetName());
            dto.setPetBread(pets.getPetBread());
            dto.setAge(pets.getAge());
            dto.setPetType(pets.getPetType());
            dto.setPetHistory(pets.getPetHistory());
            dto.setPetProblems(pets.getPetProblems());
            petResponseDtos.add(dto);

        }
        responseDto.setPetResponseDtos(petResponseDtos);
        List<AppointmentsResponseDto>dtos=new ArrayList<>();
        for(Appointments app: owner.getAppointmentsList()){
            AppointmentsResponseDto dto=new AppointmentsResponseDto();
            dto.setAppointmentDate(app.getAppointmentDate());
            dto.setStatus(app.getStatus());
//            List<VetResponseDto>vetResponseDtoList=new ArrayList<>();
//            for(Vets vets:app.getVetsList()){
//                VetResponseDto dto1=VetMapper.fromEntity(vets);
//                vetResponseDtoList.add(dto1);
//            }
//            dto.setVetsList(vetResponseDtoList);
//            dto.setOwnerResponseDto(owner.getOwnerName());

        }
        responseDto.setAppointmentsResponseDtoList(dtos);

       return responseDto;
    }
}
