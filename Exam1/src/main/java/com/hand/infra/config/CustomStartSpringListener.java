package com.hand.infra.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;


public class CustomStartSpringListener implements ApplicationListener<ContextStartedEvent> {

    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("Context Start");
    }
}
