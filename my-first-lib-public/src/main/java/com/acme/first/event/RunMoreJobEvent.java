package com.acme.first.event;

import com.acme.core.events.BaseDomainEvent;
import org.springframework.context.ApplicationEvent;

public class RunMoreJobEvent extends BaseDomainEvent<RunMoreJobData> {
    public RunMoreJobEvent(RunMoreJobData data) {
        super(data);
    }
}
