package org.choongang.member.controllers;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class MemberSearch { // 검색 범위
    @DateTimeFormat(pattern="yyyyMMdd")
    private LocalDate sDate; // 검색 시작일

    @DateTimeFormat(pattern="yyyyMMdd")
    private LocalDate eDate; // 검색 종료일
}