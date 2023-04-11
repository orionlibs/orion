package com.orion.core.computation.parallelism;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MultipleExecutionException extends Exception
{
    private final List<?> results;
    private final List<ExecutionException> exceptions;


    public MultipleExecutionException(List<?> results, List<ExecutionException> exceptions)
    {
        this.results = results;
        this.exceptions = exceptions;
    }


    public List<?> getResults()
    {
        return Collections.unmodifiableList(results);
    }


    public List<ExecutionException> getExceptions()
    {
        return Collections.unmodifiableList(exceptions);
    }
}