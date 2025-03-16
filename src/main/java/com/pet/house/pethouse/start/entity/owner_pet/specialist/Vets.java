package com.pet.house.pethouse.start.entity.owner_pet.specialist;

import com.pet.house.pethouse.start.entity.owner_pet.BaseModels;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Vets extends BaseModels {

////    @Enumerated(EnumType.STRING)
//    private String speciality;

    private String vetName;
    private String specilizationDiscription;
    private String specializationName;
    private String email;
    private String password;
    @ManyToMany
    @JoinTable(name = "Vets_roles",
            joinColumns = @JoinColumn(name = "vetId"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Roles>rolesList;

    private List<Date> schedules;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Appointments>appointmentsList;


}
