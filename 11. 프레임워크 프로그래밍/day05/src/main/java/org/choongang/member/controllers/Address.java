package org.choongang.member.controllers;

import lombok.Data;

@Data
public class Address { // 주소
    private String zipCode;
    private String address;
    private String addressSub;
}