package org.choongang.member.controllers;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberSearch { // 검색 범위
    private LocalDate sDate; // 검색 시작일
    private LocalDate eDate; // 검색 종료일
}