package com.hand.infra.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;


public class CustomCloseSpringListener implements ApplicationListener<ContextClosedEvent> {


    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        System.out.println("Context Stop");
    }
}
