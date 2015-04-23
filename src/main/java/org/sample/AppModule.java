package org.sample;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Service.class);
    }
}
