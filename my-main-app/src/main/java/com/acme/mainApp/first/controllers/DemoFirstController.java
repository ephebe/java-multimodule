package com.acme.mainApp.first.controllers;

import com.acme.core.events.DomainEventPublisher;
import com.acme.first.FlowOneService;
import com.acme.first.commands.GoodByeCommand;
import com.acme.first.commands.HelloCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("first/demo")
@Slf4j
public class DemoFirstController {
    @Autowired
    private FlowOneService flowOneService;
    @GetMapping("hello")
    public ResponseEntity<String> flowOne() {
        HelloCommand command = new HelloCommand();
        command.setName("Hugo");
        String result = flowOneService.Handle(command);
        log.info("Log Start");
        return ResponseEntity.ok(result);
    }

    @GetMapping("goodbye")
    public ResponseEntity<String> doMoreJob(@RequestParam Integer days) {
        LocalDate meetDate = LocalDate.now().plusDays(days);
        String result = flowOneService.Handle(new GoodByeCommand(meetDate));
        log.error("Very Bad",new NullPointerException("不可為空"));
        return ResponseEntity.ok(result);
    }
}
