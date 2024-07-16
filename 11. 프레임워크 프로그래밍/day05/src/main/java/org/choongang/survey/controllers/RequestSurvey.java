package org.choongang.survey.controllers;

import lombok.Data;

@Data
public class RequestSurvey { // q1, q2, q3, q4 => 커맨드 객체
    private String q1;
    private String q2;
    private String q3;
    private String q4;
}