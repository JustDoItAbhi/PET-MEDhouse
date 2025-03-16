package com.pet.house.pethouse.start.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pet.house.pethouse.start.dtos.booking.BookedOwnerResponseDto;
import com.pet.house.pethouse.start.dtos.booking.BookedPetResponseDto;
import com.pet.house.pethouse.start.dtos.booking.BookedVetResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Owner;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.AppointmentsStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class AppointmentsResponseDto {

    private Date appointmentDate;
    private AppointmentsStatus status;
    private BookedOwnerResponseDto bookedOwnerResponseDto;
    private BookedPetResponseDto bookedPetResponseDto;
    private BookedVetResponseDto bookedVetResponseDto;

}
