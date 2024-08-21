package com.acme.second.Listeners;

import com.acme.first.events.RunMoreJobData;
import com.acme.first.events.RunMoreJobEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class RunMoreJobEventListener implements ApplicationListener<RunMoreJobEvent> {
    @Override
    public void onApplicationEvent(RunMoreJobEvent event) {
        RunMoreJobData data = event.getRunMoreJobData();
        data.setDesc("Job is Completed");
    }
}
