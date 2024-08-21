package com.acme.second.generalflow.flowsecond.Listeners;

import com.acme.first.event.RunMoreJobData;
import com.acme.first.event.RunMoreJobEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class RunMoreJobEventListener implements ApplicationListener<RunMoreJobEvent> {
    @Override
    public void onApplicationEvent(RunMoreJobEvent event) {
        RunMoreJobData data = event.getData();

        data.setDesc(data.getNextMeetDate().toString());
    }
}
