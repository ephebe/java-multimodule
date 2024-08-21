package com.acme.second.services;

import com.acme.second.commands.HiCommand;

public interface FlowSecondService {
    String Handle(HiCommand command);
}
