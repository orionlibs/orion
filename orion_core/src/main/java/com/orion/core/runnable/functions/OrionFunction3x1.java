package com.orion.core.runnable.functions;

@FunctionalInterface
public interface OrionFunction3x1<T1, T2, T3, R> extends OrionFunction
{
    R run(T1 t1, T2 t2, T3 t3);
}