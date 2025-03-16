package com.pet.house.pethouse.start.controller;

import com.pet.house.pethouse.start.dtos.authentication.VetLoginDTO;
import com.pet.house.pethouse.start.dtos.requestdtos.VetRequestDto;
import com.pet.house.pethouse.start.dtos.response.VetResponseDto;
import com.pet.house.pethouse.start.services.vetservice.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vets")
public class VetController {
    @Autowired
private VetService vetService;

    @PostMapping("/vetSignUP")
    public ResponseEntity<VetResponseDto> signupVet(@RequestBody VetRequestDto dto){
        return ResponseEntity.ok(vetService.vetSignup(dto));
    }
    @PostMapping("/vetlogin")
    public ResponseEntity<VetResponseDto> VETlOGIN(@RequestBody VetLoginDTO dto){
        return ResponseEntity.ok(vetService.vetLogin(dto));
    }


}
