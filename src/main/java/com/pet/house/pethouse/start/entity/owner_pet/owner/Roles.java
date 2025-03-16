package com.pet.house.pethouse.start.entity.owner_pet.owner;

import com.pet.house.pethouse.start.entity.owner_pet.BaseModels;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.Vets;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Roles extends BaseModels {
private String role;
@ManyToMany
private List<Owner>ownerList;
    @ManyToMany
    private List<Vets>vetsList;
}
