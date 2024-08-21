package com.acme.first.flowone;

import com.acme.core.events.DomainEventPublisher;
import com.acme.first.FlowOneService;
import com.acme.first.commands.GoodByeCommand;
import com.acme.first.event.RunMoreJobData;
import com.acme.first.event.RunMoreJobEvent;
import com.acme.first.commands.HelloCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class FlowOneServiceImpl implements FlowOneService {

    @Override
    public String Handle(HelloCommand command) {
        return "Hello from " + command.getName();
    }

    @Override
    public String Handle(GoodByeCommand command) {
        RunMoreJobData data = new RunMoreJobData(command.getNextMeetDate());
        DomainEventPublisher.publishEvent(new RunMoreJobEvent(data));
        return "GoodBye from %s [meet you at %s]".formatted(this.getClass().getSimpleName(), data.getDesc());
    }
}
