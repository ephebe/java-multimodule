package com.acme.first;

import com.acme.first.commands.GoodByeCommand;
import com.acme.first.commands.HelloCommand;

public interface FlowOneService {
    String Handle(HelloCommand command);
    String Handle(GoodByeCommand command);
}
