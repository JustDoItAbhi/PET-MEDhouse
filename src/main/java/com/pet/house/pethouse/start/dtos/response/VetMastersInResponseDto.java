package com.pet.house.pethouse.start.dtos.response;

import com.pet.house.pethouse.start.entity.owner_pet.specialist.VetSpeciality;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VetMastersInResponseDto {
    private long id;
    private VetSpeciality vetSpeciality;
    private String vetSpecialityDiscription;
}
