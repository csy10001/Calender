package org.example.calender.service;

import lombok.RequiredArgsConstructor;
import org.example.calender.repository.CalenderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalenderService {

    private final CalenderRepository calenderRepository;

}
