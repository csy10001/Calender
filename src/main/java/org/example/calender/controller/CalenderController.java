package org.example.calender.controller;

import lombok.RequiredArgsConstructor;
import org.example.calender.dto.CalenderRequest;
import org.example.calender.dto.CalenderResponse;
import org.example.calender.entity.Calender;
import org.example.calender.service.CalenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CalenderController {
    private final CalenderService calenderService;

    @PostMapping("/calenders")
    public ResponseEntity<CalenderResponse> createCalender(@RequestBody CalenderRequest calender){
        return ResponseEntity.ok(calenderService.save(calender));
    }

    @GetMapping("/calenders")
    public ResponseEntity<List<CalenderResponse>> getCalenders(){
        return ResponseEntity.ok(calenderService.findCalenders());
    }

    @GetMapping("/calenders/{calenderId}")
    public ResponseEntity<CalenderResponse> getCalender(
            @PathVariable Long calenderId
    ){
        return ResponseEntity.ok(calenderService.findCalender(calenderId));
    }

    @PutMapping("/calenders/{calenderId}")
    public ResponseEntity<CalenderResponse> updateCalenderContent(
            @PathVariable Long calenderId,
            @RequestBody CalenderRequest calenderRequest
    ) {
        return ResponseEntity.ok(calenderService.updateCalenderContent(calenderId, calenderRequest));
    }

    @DeleteMapping("/calenders/{calenderId}")
    public void deleteCalender(@PathVariable Long calenderId){
        calenderService.deleteCalender(calenderId);
    }
}
