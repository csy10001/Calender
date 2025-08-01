package org.example.calender.controller;

import lombok.RequiredArgsConstructor;
import org.example.calender.service.CalenderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalenderController {
    private final CalenderService calenderService;
}
