package com.pet.house.pethouse.start.services.vetservice;

import com.pet.house.pethouse.exceptions.RoleNotExsists;
import com.pet.house.pethouse.exceptions.VetNotFoundException;
import com.pet.house.pethouse.start.dtos.authentication.VetLoginDTO;
import com.pet.house.pethouse.start.dtos.requestdtos.VetRequestDto;
import com.pet.house.pethouse.start.dtos.response.VetResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Roles;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.VetSpeciality;

import com.pet.house.pethouse.start.entity.owner_pet.specialist.Vets;
import com.pet.house.pethouse.start.mappers.VetMapper;
import com.pet.house.pethouse.start.repositories.RoleRepository;
import com.pet.house.pethouse.start.repositories.VetRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VetServicesImpl implements VetService{
    private VetRepository vetRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public VetServicesImpl(VetRepository vetRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.vetRepository = vetRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public VetResponseDto vetSignup(VetRequestDto dto) {
        // must add valdiation execption
        Optional<Vets>existingVets=vetRepository.findByEmail(dto.getEmail());
        if(existingVets.isPresent()){
            return VetMapper.fromEntity(existingVets.get());
        }


        Vets vets=new Vets();
        List<Roles>rolesList=new ArrayList<>();
        for(String role: dto.getRole()){
            Optional<Roles> roles=roleRepository.findByRole(role);
            if(roles.isEmpty()){
                throw new RoleNotExsists("PLEASE CHECK THE ROLE error in role entity "+dto.getRole());
            }
            Roles roles1=roles.get();

            rolesList.add(roles1);
            roleRepository.save(roles1);
        }
        vets.setRolesList(rolesList);
        vets.setVetName(dto.getVetName());
        vets.setEmail(dto.getEmail());
        vets.setPassword(passwordEncoder.encode(dto.getPassword()));

            vets.setSpecializationName(dto.getSpecialityName());
            vets.setSpecilizationDiscription(dto.getDiscription());

        vetRepository.save(vets);
        return VetMapper.fromEntity(vets);
    }

    @Override
    public VetResponseDto vetLogin(VetLoginDTO dto) {
        Optional<Vets>existingVets=vetRepository.findByEmail(dto.getVetEmail());
        if(existingVets.isEmpty()){
            throw new VetNotFoundException("PLEASE SIGN UP OR ENTER VALID LOGIN "+dto.getVetEmail());
        }
        if(!passwordEncoder.matches(dto.getPassword(), existingVets.get().getPassword())){
            throw new VetNotFoundException("PLEASE ENTER VALID PASSWORD "+dto.getPassword());
        }
        return VetMapper.fromEntity(existingVets.get());
    }
}
