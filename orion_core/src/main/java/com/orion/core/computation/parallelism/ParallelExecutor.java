package com.orion.core.computation.parallelism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ParallelExecutor
{
    private static final AtomicLong executorCount = new AtomicLong(0);
    private final ThreadPoolExecutor executor;
    private final AtomicLong threadCount = new AtomicLong(0);
    private final long executorId = executorCount.incrementAndGet();
    private final String namePrefix = String.format("parallel-executor-%d-thread-", executorId);


    public ParallelExecutor()
    {
        this(Runtime.getRuntime().availableProcessors());
    }


    public ParallelExecutor(int numberOfThreads)
    {
        this.executor = new ThreadPoolExecutor(numberOfThreads, numberOfThreads, 500,
                        TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadFactory()
                        {
                            @Override
                            public Thread newThread(Runnable r)
                            {
                                String threadLabel = namePrefix + threadCount.incrementAndGet();
                                Thread t = new Thread(r, threadLabel);

                                if(t.isDaemon())
                                {
                                    t.setDaemon(false);
                                }

                                if(t.getPriority() != Thread.NORM_PRIORITY)
                                {
                                    t.setPriority(Thread.NORM_PRIORITY);
                                }

                                return t;
                            }
                        });
        this.executor.allowCoreThreadTimeOut(true);
    }


    public <T> List<T> run(List<? extends Callable<T>> tasks) throws MultipleExecutionException, RuntimeException
    {
        List<T> results = new ArrayList<>(tasks.size());

        try
        {
            List<Future<T>> futures = executor.invokeAll(tasks);
            List<ExecutionException> exceptions = new ArrayList<>(futures.size());
            boolean exceptionCaught = false;

            for(Future<T> future : futures)
            {

                try
                {
                    results.add(future.get());
                    exceptions.add(null);
                }
                catch(ExecutionException ex)
                {
                    results.add(null);
                    exceptions.add(ex);
                    exceptionCaught = true;
                }

            }

            if(exceptionCaught)
            {
                throw new MultipleExecutionException(results, exceptions);
            }

        }
        catch(InterruptedException ex)
        {
            throw new RuntimeException(ex);
        }

        return results;
    }


    @SuppressWarnings("unchecked")
    public <T> List<T> run(Callable<T>... tasks) throws MultipleExecutionException
    {
        return run(Arrays.<Callable<T>>asList(tasks));
    }


    public <T> T runAndReturnFirstResult(List<? extends Callable<T>> tasks) throws ExecutionException, RuntimeException
    {
        T result = null;

        try
        {
            result = executor.invokeAny(tasks);
        }
        catch(InterruptedException ex)
        {
            throw new RuntimeException(ex);
        }

        return result;
    }


    @SuppressWarnings("unchecked")
    public <T> T runAndReturnFirstResult(Callable<T>... tasks) throws ExecutionException
    {
        return runAndReturnFirstResult(Arrays.<Callable<T>>asList(tasks));
    }
}