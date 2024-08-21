package com.acme.mainApp.second.controllers;

import com.acme.second.commands.HiCommand;
import com.acme.second.services.FlowSecondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("second/demo")
public class DemoSecondController {
    @Autowired
    private FlowSecondService secondService;
    @GetMapping("hi")
    public ResponseEntity<String> hi() {
        String result = secondService.Handle(new HiCommand());
        return ResponseEntity.ok(result);
    }
}
