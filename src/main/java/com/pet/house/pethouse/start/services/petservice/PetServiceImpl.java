package com.pet.house.pethouse.start.services.petservice;

import com.pet.house.pethouse.exceptions.OwnerNotExsitsException;
import com.pet.house.pethouse.start.dtos.requestdtos.PetRequestDto;
import com.pet.house.pethouse.start.dtos.response.OwnerResponseDto;
import com.pet.house.pethouse.start.dtos.response.PetResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Owner;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Pets;
import com.pet.house.pethouse.start.mappers.OwnerMapper;
import com.pet.house.pethouse.start.mappers.PetMapper;
import com.pet.house.pethouse.start.repositories.OwnerRepository;
import com.pet.house.pethouse.start.repositories.PetRespository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetServiceImpl implements IPetService{
    private OwnerRepository ownerRepository;
    private PetRespository petRespository;

    public PetServiceImpl(OwnerRepository ownerRepository, PetRespository petRespository) {
        this.ownerRepository = ownerRepository;
        this.petRespository = petRespository;
    }

    @Override
    public PetResponseDto createPetInfromation(PetRequestDto dto) {
        Pets pets=new Pets();
        pets.setPetName(dto.getPetName());
        pets.setPetType(dto.getPetType());
        pets.setPetBread(dto.getPetBread());
        pets.setAge(dto.getAge());
        pets.setPetProblems(dto.getPetProblems());
        pets.setPetHistory(dto.getPetHistory());
        Optional<Owner>exsistingOwner=ownerRepository.findByEmail(dto.getOwnerEmail());
        if(exsistingOwner.isEmpty()){
            throw new OwnerNotExsitsException("PET IS ABONDENT "+dto.getPetType());
        }
        pets.setOwner(exsistingOwner.get());
        petRespository.save(pets);
        return PetMapper.fromEntity(pets);
    }

    @Override
    public PetResponseDto getOwnerById(long id) {
        Optional<Pets>savedPets=petRespository.findByOwnerId(id);
        if(savedPets.isEmpty()){
            throw new OwnerNotExsitsException("PET IS ABONDENT "+id);
        }

        return PetMapper.fromEntity(savedPets.get());
    }
}
