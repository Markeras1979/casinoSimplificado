package com.prueba.casinoSimplificado;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("session created");
        event.getSession().setMaxInactiveInterval(15);
        event.getSession().invalidate();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
       System.out.println("session destroyed");
    }
}