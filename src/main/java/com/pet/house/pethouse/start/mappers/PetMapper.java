package com.pet.house.pethouse.start.mappers;

import com.pet.house.pethouse.start.dtos.booking.BookedPetResponseDto;
import com.pet.house.pethouse.start.dtos.response.OwnerResponseDto;
import com.pet.house.pethouse.start.dtos.response.PetResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Owner;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Pets;

import java.util.ArrayList;
import java.util.List;

public class PetMapper {
    public static PetResponseDto fromEntity(Pets pets){
            PetResponseDto dto=new PetResponseDto();
            dto.setId(pets.getId());
            dto.setPetName(pets.getPetName());
            dto.setPetBread(pets.getPetBread());
            dto.setAge(pets.getAge());
            dto.setPetType(pets.getPetType());
            dto.setPetHistory(pets.getPetHistory());
            dto.setPetProblems(pets.getPetProblems());
//            dto.setOwnerResponseDto(OwnerMapper.fromEntity(pets.getOwner()));
            return dto;
    }
        public static BookedPetResponseDto fromEntityForBooking(Pets pets){
                BookedPetResponseDto dto=new BookedPetResponseDto();
                dto.setId(pets.getId());
                dto.setPetName(pets.getPetName());
                dto.setPetBread(pets.getPetBread());
                dto.setAge(pets.getAge());
                dto.setPetType(pets.getPetType());
                dto.setPetHistory(pets.getPetHistory());
                dto.setPetProblems(pets.getPetProblems());
                return dto;
        }
}
