package com.pet.house.pethouse.start.services.appointments;

import com.pet.house.pethouse.start.dtos.requestdtos.AppointmentRequestDto;
import com.pet.house.pethouse.start.dtos.response.AppointmentsResponseDto;

public interface AppointmentServices {
    AppointmentsResponseDto createAppointment(AppointmentRequestDto dto);
    boolean deleteAppointment(long id);
}
