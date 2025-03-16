package com.pet.house.pethouse.start.controller;

import com.pet.house.pethouse.start.dtos.authentication.RoleRequestDto;
import com.pet.house.pethouse.start.dtos.authentication.RoleResponseDto;
import com.pet.house.pethouse.start.services.roleservice.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
private RoleServices roleServices;

    @PostMapping("/role")
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody RoleRequestDto dto){
        return ResponseEntity.ok(roleServices.createRole(dto));
    }
}
