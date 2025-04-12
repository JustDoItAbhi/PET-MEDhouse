package com.pet.house.pethouse.kafka;

import com.pet.house.pethouse.start.entity.owner_pet.owner.Addresses;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OwnerDto {
    private String ownerName;
    private String email;
    private String password;
    private String phoneNumber;
}
