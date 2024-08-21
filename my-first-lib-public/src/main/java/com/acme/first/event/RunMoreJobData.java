package com.acme.first.event;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RunMoreJobData {
    private String desc;
    private LocalDate nextMeetDate;

    public RunMoreJobData(LocalDate nextMeetDate) {
        this.nextMeetDate = nextMeetDate;
    }
}
