package com.pet.house.pethouse.start.mappers;

import com.pet.house.pethouse.start.dtos.authentication.RoleResponseDto;
import com.pet.house.pethouse.start.dtos.booking.BookedOwnerResponseDto;
import com.pet.house.pethouse.start.dtos.response.AddressResponseDto;
import com.pet.house.pethouse.start.dtos.response.OwnerResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Addresses;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Owner;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Roles;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationMapper {
    public static OwnerResponseDto fromEntity(Owner owner){
        OwnerResponseDto responseDto=new OwnerResponseDto();
        responseDto.setId(owner.getId());
        responseDto.setOwnerEmail(owner.getEmail());
        responseDto.setPassword(owner.getPassword());
        responseDto.setOwnerName(owner.getOwnerName());
        responseDto.setPhoneNumber(owner.getPhoneNumber());
        List<RoleResponseDto>roles=new ArrayList<>();
        for(Roles roles1: owner.getRolesList()){
            RoleResponseDto dto=new RoleResponseDto();
            dto.setRoles(roles1.getRole());
            roles.add(dto);
        }
        responseDto.setRolesList(roles);

        List<AddressResponseDto> addressResponseDtoList=new ArrayList<>();
        for(Addresses addresses: owner.getAddressesList()){
            AddressResponseDto dto=new AddressResponseDto();
            dto.setId(addresses.getId());
            dto.setCity(addresses.getCity());
            dto.setCountry(addresses.getCountry());
            dto.setStreet(addresses.getStreet());
            dto.setHouseNumber(addresses.getHouseNumber());
            dto.setPostalCode(addresses.getPostalCode());
            dto.setOwnerName(owner.getOwnerName());
            addressResponseDtoList.add(dto);
        }
        responseDto.setAddressesList(addressResponseDtoList);
        return responseDto;
    }
    public static BookedOwnerResponseDto fromAppointmentsOnly(Owner owner){
        BookedOwnerResponseDto responseDto=new BookedOwnerResponseDto();
        responseDto.setId(owner.getId());
        responseDto.setOwnerEmail(owner.getEmail());
        responseDto.setOwnerName(owner.getOwnerName());
        responseDto.setPhoneNumber(owner.getPhoneNumber());

        List<AddressResponseDto> addressResponseDtoList=new ArrayList<>();
        for(Addresses addresses: owner.getAddressesList()){
            AddressResponseDto dto=new AddressResponseDto();
            dto.setId(addresses.getId());
            dto.setCity(addresses.getCity());
            dto.setCountry(addresses.getCountry());
            dto.setStreet(addresses.getStreet());
            dto.setHouseNumber(addresses.getHouseNumber());
            dto.setPostalCode(addresses.getPostalCode());
            addressResponseDtoList.add(dto);
        }
        responseDto.setAddressesList(addressResponseDtoList);
        return responseDto;
    }
}
