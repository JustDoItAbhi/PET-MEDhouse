package com.pet.house.pethouse.start.entity.owner_pet.owner;

import com.pet.house.pethouse.start.entity.owner_pet.BaseModels;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.Appointments;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Owner extends BaseModels {
    private String ownerName;
    @OneToMany(mappedBy = "owner",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Addresses> addressesList;
    private String email;
    private String password;
    private String phoneNumber;
    private String petName;

    @ManyToMany
    @JoinTable(name = "Owner_roles",
    joinColumns = @JoinColumn(name = "ownerId"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Roles>rolesList;


    @OneToMany(mappedBy = "owner",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Pets>petsList;


    @OneToMany(mappedBy = "owner",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Appointments>appointmentsList;
}
