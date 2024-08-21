package com.acme.first.services.impl;

import com.acme.first.events.RunMoreJobData;
import com.acme.first.events.RunMoreJobEvent;
import com.acme.first.services.MyFirstServiceContract;
import com.acme.second.services.MySecondServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService implements MyFirstServiceContract {
    @Autowired
    private ApplicationEventPublisher events;

    public MyFirstService() {
    }
    @Override
    public String returnSomeResult() {
        return "Hi from " + this.getClass().getSimpleName();
    }

    public String returnMoreResult() {
        RunMoreJobData data = new RunMoreJobData();
        events.publishEvent(new RunMoreJobEvent(data));
        return "Hi from %s [i fire event then %s]".formatted(this.getClass().getSimpleName(), data.getDesc());
    }
}
