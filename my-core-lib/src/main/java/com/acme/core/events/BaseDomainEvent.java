package com.acme.core.events;

import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public abstract class BaseDomainEvent<T> extends ApplicationEvent {
    /**
     * 发生时间
     */
    private LocalDateTime occurredOn;
    /**
     * 领域事件数据
     */
    private T data;
    public BaseDomainEvent(T data) {
        super(data);
        this.data = data;
        this.occurredOn = LocalDateTime.now();
    }

    public T getData() {
        return this.data;
    }
}
