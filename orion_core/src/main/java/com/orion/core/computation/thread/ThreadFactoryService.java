package com.orion.core.computation.thread;

import com.orion.core.abstraction.OrionService;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactoryService extends OrionService
{
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private ThreadGroup group;


    public ThreadFactoryService(String poolName)
    {
        this.group = new ThreadGroup(poolName + "-" + poolNumber.getAndIncrement());
    }


    public static ThreadFactoryService of(String poolName)
    {
        return new ThreadFactoryService(poolName);
    }


    public Thread newThread(Runnable runnable)
    {
        return new Thread(group, runnable, group.getName() + "-thread-" + threadNumber.getAndIncrement());
    }


    public Thread newThreadAndRun(Runnable runnable)
    {
        Thread thread = new Thread(group, runnable, group.getName() + "-thread-" + threadNumber.getAndIncrement());
        thread.start();
        return thread;
    }
}