package com.pet.house.pethouse.start.controller;

import com.pet.house.pethouse.start.dtos.authentication.LoginRequestDto;
import com.pet.house.pethouse.start.dtos.authentication.Signup;
import com.pet.house.pethouse.start.dtos.requestdtos.AppointmentRequestDto;
import com.pet.house.pethouse.start.dtos.requestdtos.PetRequestDto;
import com.pet.house.pethouse.start.dtos.response.AppointmentsResponseDto;
import com.pet.house.pethouse.start.dtos.response.OwnerResponseDto;
import com.pet.house.pethouse.start.dtos.response.PetResponseDto;
import com.pet.house.pethouse.start.services.appointments.AppointmentServices;
import com.pet.house.pethouse.start.services.ownerservice.OwnerService;
import com.pet.house.pethouse.start.services.petservice.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookAppointment {
    @Autowired
private OwnerService ownerService;

    @Autowired
    private IPetService petService;
    @Autowired
    private AppointmentServices appointmentServices;



    @PostMapping("/signup")
    public ResponseEntity<OwnerResponseDto> signup(@RequestBody Signup dto){
        return ResponseEntity.ok(ownerService.signup(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<OwnerResponseDto> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(ownerService.login(dto));
    }
//    @GetMapping("/{email}")
//    public ResponseEntity<OwnerResponseDto> login(@PathVariable ("email")String email){
//        return ResponseEntity.ok(ownerService.getByEmail(email));
//    }
    @GetMapping("/{id}")
    public ResponseEntity<OwnerResponseDto> login(@PathVariable ("id")long id){
        return ResponseEntity.ok(ownerService.getOwnerById(id));
    }


    @PostMapping("/pet")
    public ResponseEntity<PetResponseDto> createPetInfo(@RequestBody PetRequestDto dto){
        return ResponseEntity.ok(petService.createPetInfromation(dto));
    }
    @GetMapping("/pet/{id}")
    public ResponseEntity<PetResponseDto> createPetInfo(@PathVariable("id")long id){
        return ResponseEntity.ok(petService.getOwnerById(id));
    }



    @PostMapping("/")
    public ResponseEntity<AppointmentsResponseDto> bookapp(@RequestBody AppointmentRequestDto dto){
        return ResponseEntity.ok(appointmentServices.createAppointment(dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable ("id")long id){
        return ResponseEntity.ok(appointmentServices.deleteAppointment(id));
    }
}
