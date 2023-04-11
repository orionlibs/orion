package com.orion.core.computation.annotation.concurrency;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(
{ElementType.TYPE})
public @interface Concurrency
{
    int threads() default 4;
}