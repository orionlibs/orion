package com.orion.core.computation.parallelism;

public interface IterationBody<T>
{
    void run(T item);
}