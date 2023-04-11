package com.orion.core.runnable;

public class OrionJobService
{
    public static void runJob(OrionJob job)
    {
        new Thread(job).start();
    }


    public static void runJobWithCurrentThreadName(OrionJob job)
    {
        Thread thread = new Thread(job);
        thread.setName(Thread.currentThread().getName());
        thread.start();
    }
}