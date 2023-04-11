package com.orion.core.computation.thread.tasks;

import com.orion.core.computation.annotation.concurrency.Concurrency;

public class GetNumberOfAvailableThreadsTask
{
    public static int run()
    {
        return Runtime.getRuntime().availableProcessors();
    }


    public static int run(final Class<?> classWithConcurrencyAnnotation)
    {

        if(classWithConcurrencyAnnotation.isAnnotationPresent(Concurrency.class))
        {
            int numberOfRequestedThreads = classWithConcurrencyAnnotation.getAnnotation(Concurrency.class).threads();
            return Math.min(numberOfRequestedThreads, run());
        }
        else
        {
            return run();
        }

    }
}