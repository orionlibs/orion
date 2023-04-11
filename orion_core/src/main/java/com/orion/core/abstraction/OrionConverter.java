package com.orion.core.abstraction;

public interface OrionConverter<SOURCE, TARGET>
{
    TARGET convert(SOURCE source, TARGET target);
}