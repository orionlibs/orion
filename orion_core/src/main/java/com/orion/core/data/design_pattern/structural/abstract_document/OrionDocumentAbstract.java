package com.orion.core.data.design_pattern.structural.abstract_document;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class OrionDocumentAbstract implements OrionDocument
{
    private final Map<String, Object> objectProperties;


    protected OrionDocumentAbstract(Map<String, Object> objectProperties)
    {
        Objects.requireNonNull(objectProperties, "properties map is required");
        this.objectProperties = objectProperties;
    }


    @Override
    public void put(String key, Object value)
    {
        objectProperties.put(key, value);
    }


    @Override
    public Object get(String key)
    {
        return objectProperties.get(key);
    }


    @SuppressWarnings("unchecked")
    @Override
    public <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor)
    {
        return Stream.ofNullable(get(key))
                        .filter(Objects::nonNull)
                        .map(x -> (List<Map<String, Object>>)x)
                        .findAny()
                        .stream()
                        .flatMap(Collection::stream)
                        .map(constructor);
    }
}
