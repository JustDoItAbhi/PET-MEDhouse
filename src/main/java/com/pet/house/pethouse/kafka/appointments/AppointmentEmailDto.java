package com.pet.house.pethouse.kafka.appointments;

import com.pet.house.pethouse.start.entity.owner_pet.specialist.AppointmentsStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppointmentEmailDto {
    private AppointmentsStatus status;
    private Date date;
    private String ownerName;
    private String ownerEmail;
    private String petName;
    private String problemWithPet;
    private String petBread;
    private String historyOfPet;
    private String vetName;
    private String specialization;
    private String specializationDescription;
    private String vetEmail;

}
