package com.pet.house.pethouse.start.entity.owner_pet.owner;

import com.pet.house.pethouse.start.entity.owner_pet.BaseModels;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pets extends BaseModels {
    private String petName;
    private int age;
    @Enumerated(EnumType.STRING)
    private PetType petType;
    private String petBread;
    private String petProblems;
    private String petHistory;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;
}
