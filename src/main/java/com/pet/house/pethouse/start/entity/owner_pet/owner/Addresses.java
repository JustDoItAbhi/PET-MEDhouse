package com.pet.house.pethouse.start.entity.owner_pet.owner;

import com.pet.house.pethouse.start.entity.owner_pet.BaseModels;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Addresses extends BaseModels {
    private String country;
    private String city;
    private String street;
    private int houseNumber;
    private int postalCode;
    @ManyToOne
    private Owner owner;
}
