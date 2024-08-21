package com.acme.core.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DomainEventPublisher {
    private static final Logger logger
            = LoggerFactory.getLogger(DomainEventPublisher.class);
    private static ObjectMapper mapper;
    private static ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        DomainEventPublisher.applicationEventPublisher = applicationEventPublisher;
    }
    @Autowired
    public void setMapper(ObjectMapper mapper) {
        DomainEventPublisher.mapper = mapper;
    }
    public static <T> void publishEvent(BaseDomainEvent<T> event) {
        try {
            logger.info("发布事件,event:{}",  mapper.writeValueAsString(event));
            applicationEventPublisher.publishEvent(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
