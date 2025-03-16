package com.pet.house.pethouse.start.entity.owner_pet.specialist;

import com.pet.house.pethouse.start.entity.owner_pet.BaseModels;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class VetMastersIn extends BaseModels {
    @Enumerated(EnumType.STRING)
    private VetSpeciality vetSpeciality;

    private String vetSpecialityDiscription;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Vets> vetList;
}
