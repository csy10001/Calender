package org.example.calender.service;

import lombok.RequiredArgsConstructor;
import org.example.calender.dto.CalenderRequest;
import org.example.calender.dto.CalenderResponse;
import org.example.calender.entity.Calender;
import org.example.calender.repository.CalenderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalenderService {

    private final CalenderRepository calenderRepository;

    @Transactional
    public CalenderResponse save(CalenderRequest calenderRequest) {
        Calender calender = new Calender(
                calenderRequest.getContent(),
                calenderRequest.getWriter()
        );
        Calender savedCalender = calenderRepository.save(calender);

        return new CalenderResponse(
                savedCalender.getId(),
                savedCalender.getContent(),
                savedCalender.getWriter(),
                savedCalender.getCreatedDate(),
                savedCalender.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<CalenderResponse> findCalenders(){
        List<Calender> calenders = calenderRepository.findAll();
        List<CalenderResponse> dtos =  new ArrayList<>();

        for (Calender calender : calenders) {
            new CalenderResponse(
                    calender.getId(),
                    calender.getContent(),
                    calender.getWriter(),
                    calender.getCreatedDate(),
                    calender.getModifiedAt()
            );
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public CalenderResponse findCalender(Long calenderId){
        Calender calender = calenderRepository.findById(calenderId).orElseThrow(
                () -> new IllegalArgumentException("입력하신 일정이 없습니다.")
        );
        return new CalenderResponse(
                        calender.getId(),
                        calender.getContent(),
                        calender.getWriter(),
                        calender.getCreatedDate(),
                        calender.getModifiedAt()
                );
    }

    @Transactional
    public CalenderResponse updateCalenderContent(Long calenderId, CalenderRequest request) {
        Calender calender = calenderRepository.findById(calenderId).orElseThrow(
                () -> new IllegalArgumentException("입력하신 일정이 없습니다.")
        );
        calender.updateCalenderContent(request.getContent());
        return new CalenderResponse(
                calender.getId(),
                calender.getContent(),
                calender.getWriter(),
                calender.getCreatedDate(),
                calender.getModifiedAt()
        );
    }

    @Transactional
    public void deleteCalender(Long calenderId){
        boolean b = calenderRepository.existsById(calenderId);
        if(!b) {
            throw new IllegalStateException("입력하신 일정이 없습니다.");
        }
        calenderRepository.deleteById(calenderId);
    }
}
