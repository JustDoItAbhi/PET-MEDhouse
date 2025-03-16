package com.pet.house.pethouse.start.dtos.requestdtos;

import com.pet.house.pethouse.start.dtos.response.OwnerResponseDto;
import com.pet.house.pethouse.start.dtos.response.PetResponseDto;
import com.pet.house.pethouse.start.dtos.response.VetResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Owner;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Pets;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.AppointmentsStatus;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.Vets;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class AppointmentRequestDto {

    private String ownerEmail;
    private String vetSpeacialization;
    private Date appointmentDate;
    private AppointmentsStatus status;

}
