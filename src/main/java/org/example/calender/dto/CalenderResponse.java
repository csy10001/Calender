package org.example.calender.dto;

import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
public class CalenderResponse {
    private final Long id;
    private final String content;
    private final String writer;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CalenderResponse(Long id, String content, String writer,LocalDateTime createdAt , LocalDateTime modifiedAt) {
        this.id = id;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
