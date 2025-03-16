package com.pet.house.pethouse.start.dtos.response;

import com.pet.house.pethouse.start.dtos.authentication.RoleResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.Appointments;

import com.pet.house.pethouse.start.entity.owner_pet.specialist.VetSpeciality;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class VetResponseDto {
    private long id;
    private String vetName;
    private List<RoleResponseDto>roleResponseDtoList;
    private String specility;
    private String specilityDiscription;
//    private VetMastersInResponseDto vetsMasterResponseDto;
    private String email;
    private String password;
    private List<Date> schedules;
    private List<Appointments>appointmentsList;
}
