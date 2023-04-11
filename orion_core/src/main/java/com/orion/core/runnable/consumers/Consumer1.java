package com.orion.core.runnable.consumers;

@FunctionalInterface
public interface Consumer1<T1> extends OrionConsumer
{
    void run(T1 t1);
}