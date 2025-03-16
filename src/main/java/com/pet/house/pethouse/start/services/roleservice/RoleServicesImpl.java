package com.pet.house.pethouse.start.services.roleservice;

import com.pet.house.pethouse.exceptions.RoleNotExsists;
import com.pet.house.pethouse.start.dtos.authentication.RoleRequestDto;
import com.pet.house.pethouse.start.dtos.authentication.RoleResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Roles;
import com.pet.house.pethouse.start.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServicesImpl implements RoleServices {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleResponseDto createRole(RoleRequestDto dto) {

        Optional<Roles>existingRole=roleRepository.findByRole(dto.getRoles());
        if(existingRole.isPresent()){
            throw new RoleNotExsists(" ROLE ALREADY EXISTS "+dto.getRoles());
        }
        Roles roles=new Roles();
        roles.setRole(dto.getRoles());
        roleRepository.save(roles);
        return fromEntity(roles);
    }
    private RoleResponseDto fromEntity(Roles roles){
        RoleResponseDto dto=new RoleResponseDto();
        dto.setRoles(roles.getRole());
    return dto;
    }
}
