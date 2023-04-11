package com.orion.core.runnable.functions;

@FunctionalInterface
public interface OrionFunction2xN<T1, T2, R> extends OrionFunction
{
    R[] run(T1 t1, T2 t2);
}