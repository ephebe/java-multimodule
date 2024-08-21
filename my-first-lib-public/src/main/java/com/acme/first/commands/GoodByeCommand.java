package com.acme.first.commands;


import java.time.LocalDate;

public class GoodByeCommand {
    private LocalDate nextMeetDate;

    public GoodByeCommand(LocalDate nextMeetDate) {
        this.nextMeetDate = nextMeetDate;
    }

    public LocalDate getNextMeetDate() {
        return this.nextMeetDate;
    }
}
