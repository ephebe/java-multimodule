package com.acme.second.generalflow.flowsecond;

import com.acme.first.FlowOneService;
import com.acme.first.commands.HelloCommand;
import com.acme.second.commands.HiCommand;
import com.acme.second.services.FlowSecondService;
import com.acme.first.commands.GoodByeCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowSecondServiceImpl implements FlowSecondService {
    @Autowired
    private FlowOneService flowOneService;

    @Override
    public String Handle(HiCommand command) {
        HelloCommand heCommand = new HelloCommand();
        heCommand.setName("Hugo");
        return "Hi from %s [%s] from firstOneService ".formatted(this.getClass().getSimpleName(), flowOneService.Handle(heCommand));
    }
}
