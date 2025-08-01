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
                calenderRequest.getTitle(),
                calenderRequest.getContent(),
                calenderRequest.getWriter(),
                calenderRequest.getPassword()
        );
        Calender savedCalender = calenderRepository.save(calender);

        return new CalenderResponse(
                savedCalender.getId(),
                savedCalender.getTitle(),
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
                    calender.getTitle(),
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
                        calender.getTitle(),
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
        if(!calender.getPassword().equals(request.getPassword())){
            throw new IllegalStateException("비밀번호가 틀렸네용");
        }
        calender.updateCalenderContent(request.getTitle(), request.getContent());
        return new CalenderResponse(
                calender.getId(),
                calender.getTitle(),
                calender.getContent(),
                calender.getWriter(),
                calender.getCreatedDate(),
                calender.getModifiedAt()
        );
    }

    @Transactional
    public void deleteCalender(Long calenderId, String password) {
        Calender calender = calenderRepository.findById(calenderId).orElseThrow(
                () -> new IllegalArgumentException("입력하신 일정이 없습니다.")
        );

        if (!calender.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        calenderRepository.delete(calender);
    }

}
