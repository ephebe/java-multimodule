package com.acme.first.events;

import org.springframework.context.ApplicationEvent;

public class RunMoreJobEvent extends ApplicationEvent {
    private RunMoreJobData data;
    public RunMoreJobEvent(RunMoreJobData data) {
        super(data);
        this.data = data;
    }

    public RunMoreJobData getRunMoreJobData() {
        return data;
    }
}
