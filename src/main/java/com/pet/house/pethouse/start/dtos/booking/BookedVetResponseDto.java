package com.pet.house.pethouse.start.dtos.booking;

import com.pet.house.pethouse.start.dtos.authentication.RoleResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.Appointments;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class BookedVetResponseDto {
    private long id;
    private String vetName;
    private String specility;
    private String specilityDiscription;
    private String email;

    private List<Date> schedules;
//    private List<Appointments>appointmentsList;
}
