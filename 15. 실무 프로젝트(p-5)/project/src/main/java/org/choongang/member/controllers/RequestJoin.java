package org.choongang.member.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestJoin {
    @NotBlank
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
    private String mobile;
}