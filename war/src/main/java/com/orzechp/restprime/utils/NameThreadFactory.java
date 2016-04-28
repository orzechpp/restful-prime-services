package com.orzechp.restprime.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NameThreadFactory implements ThreadFactory {

    private final String name;
    private final boolean threadDaemon;
    private final AtomicInteger counter = new AtomicInteger();

    public NameThreadFactory(String name, boolean threadDaemon) {
        this.name = name;
        this.threadDaemon = threadDaemon;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-" + counter.getAndIncrement());

        if (threadDaemon) {
            thread.setDaemon(true);
        }
        return thread;
    }

}
