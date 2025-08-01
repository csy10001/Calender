package org.example.calender.dto;

import lombok.Getter;

@Getter
public class CalenderRequest {
    private String title;
    private String content;
    private String writer;
    private String password;
}
