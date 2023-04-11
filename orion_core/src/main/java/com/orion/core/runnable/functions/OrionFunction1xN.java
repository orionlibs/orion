package com.orion.core.runnable.functions;

@FunctionalInterface
public interface OrionFunction1xN<T1, R> extends OrionFunction
{
    R[] run(T1 t1);
}