package com.orion.core.runnable.functions;

@FunctionalInterface
public interface OrionFunctionNx0<T> extends OrionFunction
{
    @SuppressWarnings("unchecked")
    void run(T... args);
}