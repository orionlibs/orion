package com.orion.math.geometry.vector.generic;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.object.CloningService;
import com.orion.core.stream.OrionStream;
import com.orion.math.MathObject;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenericVector implements MathObject, Cloneable
{
    private OrionList<Object> elements;


    public GenericVector()
    {
        this.elements = OrionArrayList.<Object>of();
    }


    public GenericVector(int dimensions)
    {
        this.elements = OrionArrayList.<Object>of(dimensions);
    }


    public GenericVector(OrionList<Object> elements)
    {
        GenericVectorRules.isValid(elements);
        this.elements = elements;
    }


    public GenericVector(Object[] elements)
    {
        GenericVectorRules.isValid(elements);
        this.elements = OrionArrayList.<Object>of(elements);
    }


    public GenericVector(List<Object> elements)
    {
        GenericVectorRules.isValid(elements);
        this.elements = OrionArrayList.<Object>of(elements);
    }


    public static GenericVector of()
    {
        return new GenericVector();
    }


    public static GenericVector of(int dimensions)
    {
        return new GenericVector(dimensions);
    }


    public static GenericVector of(OrionList<Object> elements)
    {
        return new GenericVector(elements);
    }


    public static GenericVector of(Object[] elements)
    {
        return new GenericVector(elements);
    }


    public static GenericVector of(List<Object> elements)
    {
        return new GenericVector(elements);
    }


    public Object[] getAsArray()
    {
        return getElements().getAsArray();
    }


    public Object[] getAsArrayCopy()
    {
        return getCopy().getElements().getAsArray();
    }


    public List<Object> getAsList()
    {
        return getElements().getAsList();
    }


    public List<Object> getAsListCopy()
    {
        return getCopy().getAsList();
    }


    public OrionList<Object> getAsOrionList()
    {
        return getElements();
    }


    public OrionList<Object> getAsOrionListCopy()
    {
        return getCopy().getAsOrionList();
    }


    public int getDimensions()
    {
        return getSize();
    }


    public int getSize()
    {
        return getElements().getSize();
    }


    public boolean isEmpty()
    {
        return getElements().isEmpty();
    }


    public Stream<Object> filter(Predicate<Object> filterToApply)
    {
        return getElements().filter(filterToApply);
    }


    public boolean findAny(Predicate<Object> filterToApply)
    {
        return getElements().findAny(filterToApply);
    }


    public boolean findAny(IntPredicate filterToApply)
    {
        return OrionStream.findAny(elements, filterToApply);
    }


    public void forAll(Consumer<Object> action)
    {
        getElements().forAll(action);
    }


    public void forAllIndices(IntConsumer action)
    {
        IntStream.range(0, elements.getSize()).forEach(action);
    }


    public void forAll(Stream<Object> stream, Consumer<Object> action)
    {
        getElements().forAll(stream, action);
    }


    public void forAllIndices(IntStream stream, IntConsumer action)
    {
        OrionStream.forAll(stream, action);
    }


    public void filterAndLoop(Predicate<Object> filterToApply, Consumer<Object> action)
    {
        forAll(filter(filterToApply), action);
    }


    public void filterAndLoopIndices(IntPredicate filterToApply, IntConsumer action)
    {
        OrionStream.filterAndLoop(elements, filterToApply, action);
    }


    public Object getFirst()
    {
        return getAsArray()[0];
    }


    public Object getLast()
    {
        return getAsArray()[getElements().getSize() - 1];
    }


    public void add(Object element)
    {
        getElements().add(element);
    }


    public void set(int index, Object element)
    {
        getElements().set(index, element);
    }


    public void delete(int index)
    {
        getElements().delete(index);
    }


    public void delete(int[] indices)
    {
        getElements().delete(indices);
    }


    public void delete(List<Integer> indices)
    {
        getElements().delete(indices);
    }


    public void deleteAll()
    {
        getElements().deleteAll();
    }


    public Object get(int index)
    {
        return getElements().get(index);
    }


    public GenericVector reverseOrderOfElements()
    {
        return GenericVectorService.reverseOrderOfElements(this);
    }


    @Override
    public GenericVector clone() throws CloneNotSupportedException
    {
        return (GenericVector)CloningService.clone(this);
    }


    public GenericVector getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public int hashCode()
    {
        return GenericVectorInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return GenericVectorInternalService.equals(this, object);
    }


    public OrionList<Object> getElements()
    {
        return this.elements;
    }


    public void setElements(OrionList<Object> elements)
    {
        this.elements = elements;
    }
}