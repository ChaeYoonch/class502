package org.choongang.user.controllers;

public record RequestLogin (
        String email,
        String password
) {}