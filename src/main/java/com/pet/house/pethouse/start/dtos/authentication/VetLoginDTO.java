package com.pet.house.pethouse.start.dtos.authentication;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class VetLoginDTO {
    @NotNull
    private String vetEmail;
    @NotNull
    private String password;
}
