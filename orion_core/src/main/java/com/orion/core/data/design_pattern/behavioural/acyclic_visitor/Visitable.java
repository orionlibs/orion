package com.orion.core.data.design_pattern.behavioural.acyclic_visitor;

public interface Visitable<T>
{
    public void accept(VisitorIF<T> visitor);
}
