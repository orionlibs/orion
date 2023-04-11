package com.orion.core.computation.parallelism;

import com.orion.core.computation.parallelism.SynchronizedIterator.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class ParallelFor
{
    private final int numberOfThreads;
    private final ParallelExecutor executor;


    public ParallelFor()
    {
        this(Runtime.getRuntime().availableProcessors());
    }


    public ParallelFor(int numberOfThreads)
    {
        this.numberOfThreads = numberOfThreads;
        this.executor = new ParallelExecutor(numberOfThreads);
    }


    public void forEach(int start, int end, final int increment, final LoopBody body) throws MultipleExecutionException
    {
        List<Callable<Void>> tasks = new ArrayList<Callable<Void>>(numberOfThreads);
        int blockSize = (int)Math.ceil((end - start) / (double)increment / (double)numberOfThreads) * increment;
        blockSize = Math.max(1, blockSize);

        for(int i = 0; i < numberOfThreads; ++i)
        {
            final int threadStartIndex = start + i * blockSize;

            if(threadStartIndex >= end)
            {
                break;
            }

            final int threadEndIndex = Math.min(threadStartIndex + blockSize, end);
            tasks.add(new Callable<Void>()
            {
                @Override
                public Void call() throws Exception
                {

                    for(int j = threadStartIndex; j < threadEndIndex; j += increment)
                    {
                        body.run(j);
                    }

                    return null;
                }
            });
        }

        executor.run(tasks);
    }


    public void forEach(int start, int end, LoopBody body) throws MultipleExecutionException
    {
        forEach(start, end, 1, body);
    }


    public void forEach(boolean conditionToParallelize, int start, int end, int increment, LoopBody body) throws MultipleExecutionException
    {

        if(conditionToParallelize)
        {
            forEach(start, end, increment, body);
        }
        else
        {

            try
            {

                for(int i = start; i < end; i += increment)
                {
                    body.run(i);
                }

            }
            catch(Exception ex)
            {
                throw new MultipleExecutionException(Arrays.<Void>asList((Void)null), Arrays.<ExecutionException>asList(new ExecutionException(ex)));
            }

        }

    }


    public void forEach(boolean conditionToParallelize, int start, int end, LoopBody body) throws MultipleExecutionException
    {
        forEach(conditionToParallelize, start, end, 1, body);
    }


    public <T> void forEach(Iterable<T> iterable, final IterationBody<T> body) throws MultipleExecutionException
    {
        List<Callable<Void>> tasks = new ArrayList<Callable<Void>>(numberOfThreads);
        final SynchronizedIterator<T> iterator = new SynchronizedIterator<>(iterable.iterator());

        for(int i = 0; i < numberOfThreads; ++i)
        {
            tasks.add(new Callable<Void>()
            {
                @Override
                public Void call() throws Exception
                {

                    for(Element<T> element; (element = iterator.next()).exists();)
                    {
                        body.run(element.get());
                    }

                    return null;
                }
            });
        }

        executor.run(tasks);
    }


    public <T> void forEach(boolean conditionToParallelize, Iterable<T> iterable, IterationBody<T> body) throws MultipleExecutionException
    {

        if(conditionToParallelize)
        {
            forEach(iterable, body);
        }
        else
        {

            for(T item : iterable)
            {
                body.run(item);
            }

        }

    }
}