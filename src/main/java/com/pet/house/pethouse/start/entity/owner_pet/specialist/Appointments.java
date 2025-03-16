package com.pet.house.pethouse.start.entity.owner_pet.specialist;

import com.pet.house.pethouse.start.entity.owner_pet.BaseModels;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Owner;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Pets;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@Entity
public class Appointments extends BaseModels {

    @ManyToOne
    private Pets pets;
    @ManyToOne
    private Owner owner;
    @ManyToOne
    private Vets vetsList;
    private Date appointmentDate;
    @Enumerated(EnumType.STRING)
    private AppointmentsStatus status;
}
