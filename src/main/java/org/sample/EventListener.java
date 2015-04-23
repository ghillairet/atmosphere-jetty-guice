package org.sample;

import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

import javax.inject.Inject;

public class EventListener implements AtmosphereResourceEventListener {

    private Service service;

    @Inject
    void setEventBus(Service service) {
        this.service = service;
    }

    @Override
    public void onPreSuspend(AtmosphereResourceEvent event) {

    }

    @Override
    public void onSuspend(AtmosphereResourceEvent event) {

    }

    @Override
    public void onResume(AtmosphereResourceEvent event) {

    }

    @Override
    public void onDisconnect(AtmosphereResourceEvent event) {

    }

    @Override
    public void onBroadcast(AtmosphereResourceEvent event) {

    }

    @Override
    public void onThrowable(AtmosphereResourceEvent event) {

    }

    @Override
    public void onClose(AtmosphereResourceEvent event) {

    }

    @Override
    public void onHeartbeat(AtmosphereResourceEvent event) {

    }
}
