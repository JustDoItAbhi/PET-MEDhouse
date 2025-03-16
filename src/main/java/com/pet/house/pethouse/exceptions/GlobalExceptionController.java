package com.pet.house.pethouse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {
@ExceptionHandler(OwnerNotExsitsException.class)
    public ResponseEntity<MessageDto> ownerNotExsists(OwnerNotExsitsException e){
    MessageDto dto=new MessageDto(
            e.getMessage(),
            404
    );
    return new  ResponseEntity<>( dto,HttpStatus.FORBIDDEN);
}
    @ExceptionHandler(RoleNotExsists.class)
    public ResponseEntity<MessageDto> roleNotExsists(RoleNotExsists e){
        MessageDto dto=new MessageDto(
                e.getMessage(),
                404
        );
        return new  ResponseEntity<>( dto,HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(VetNotFoundException.class)
    public ResponseEntity<MessageDto> VetNotExsists(VetNotFoundException e){
        MessageDto dto=new MessageDto(
                e.getMessage(),
                404
        );
        return new  ResponseEntity<>( dto,HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AppointmentAlreadyBooked.class)
    public ResponseEntity<MessageDto> noAppointments(AppointmentAlreadyBooked e){
        MessageDto dto=new MessageDto(
                e.getMessage(),
                404
        );
        return new  ResponseEntity<>( dto,HttpStatus.FORBIDDEN);
    }
}
