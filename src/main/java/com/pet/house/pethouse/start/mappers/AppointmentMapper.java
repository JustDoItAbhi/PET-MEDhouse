package com.pet.house.pethouse.start.mappers;

import com.pet.house.pethouse.start.dtos.response.AppointmentsResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.Appointments;

import java.time.format.DateTimeFormatter;

public class AppointmentMapper {

    public static AppointmentsResponseDto fromEntity(Appointments appointments){


        AppointmentsResponseDto responseDto=new AppointmentsResponseDto();
        responseDto.setStatus(appointments.getStatus());
        responseDto.setAppointmentDate(appointments.getAppointmentDate());
        responseDto.setBookedPetResponseDto(PetMapper.fromEntityForBooking(appointments.getPets()));
        responseDto.setBookedOwnerResponseDto(AuthenticationMapper.fromAppointmentsOnly(appointments.getOwner()));
        responseDto.setBookedVetResponseDto(VetMapper.fromEntityForBooking(appointments.getVetsList()));
        return responseDto;
    }
}
