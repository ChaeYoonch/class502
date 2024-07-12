package org.choongang.member.controllers;

public record RequestLogin2(
        String email,
        String password
) {} // public record RequestLogin2() 의 () 안에 매개변수 형태로 값 설정