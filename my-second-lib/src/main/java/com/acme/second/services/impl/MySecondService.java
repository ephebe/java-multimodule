package com.acme.second.services.impl;

import com.acme.first.services.MyFirstServiceContract;
import com.acme.second.services.MySecondServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySecondService implements MySecondServiceContract {
    @Autowired
    private MyFirstServiceContract myFirstServiceContract;

    public MySecondService() {
    }

    @Override
    public String returnSomeResult() {
        return "Hi from %s [i depends on %s]".formatted(this.getClass().getSimpleName(), myFirstServiceContract.returnSomeResult());

    }
}
