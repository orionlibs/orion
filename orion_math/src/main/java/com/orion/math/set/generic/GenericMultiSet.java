package com.orion.math.set.generic;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashMultiSet;
import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.number.ANumber;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class GenericMultiSet implements MathObject, Cloneable
{
    private OrionSet<Object> elements;


    public GenericMultiSet()
    {
        this.elements = OrionHashMultiSet.<Object>of();
    }


    public GenericMultiSet(OrionSet<Object> elements)
    {
        GenericSetRules.isValid(elements);
        this.elements = OrionHashMultiSet.<Object>of(elements);
    }


    public GenericMultiSet(List<Object> elements)
    {
        GenericSetRules.isValid(elements);
        this.elements = OrionHashMultiSet.<Object>of(elements);
    }


    public static GenericMultiSet of()
    {
        return new GenericMultiSet();
    }


    public static GenericMultiSet of(OrionSet<Object> elements)
    {
        return new GenericMultiSet(elements);
    }


    public static GenericMultiSet of(List<Object> elements)
    {
        return new GenericMultiSet(elements);
    }


    public int getSize()
    {
        GenericSetRules.isNotEmpty(getElements());
        return getElements().getSize();
    }


    public boolean contains(Object element)
    {
        GenericSetRules.isNotEmpty(getElements());
        return getElements().contains(element);
    }


    public boolean notContains(Object element)
    {
        return !getElements().contains(element);
    }


    public boolean containsValue(Object value)
    {
        return GenericMultiSetService.containsValue(this, value);
    }


    public boolean notContainsValue(Object value)
    {
        return !containsValue(value);
    }


    public boolean isEmpty()
    {
        return getElements().isEmpty();
    }


    public boolean isNotEmpty()
    {
        return !getElements().isEmpty();
    }


    public GenericMultiSet getUnion(OrionSet<Object> other)
    {
        return GenericMultiSetService.getUnion(this, other);
    }


    public GenericMultiSet getUnion(GenericMultiSet other)
    {
        return GenericMultiSetService.getUnion(this, other);
    }


    public GenericMultiSet getUnion(GenericSet other)
    {
        return GenericMultiSetService.getUnion(this, other);
    }


    public GenericMultiSet getIntersection(OrionSet<Object> other)
    {
        return GenericMultiSetService.getIntersection(this, other);
    }


    public GenericMultiSet getIntersection(GenericMultiSet other)
    {
        return GenericMultiSetService.getIntersection(this, other);
    }


    public GenericMultiSet getIntersection(GenericSet other)
    {
        return GenericMultiSetService.getIntersection(this, other);
    }


    public GenericMultiSet getDifference(OrionSet<Object> other)
    {
        return GenericMultiSetService.getDifference(this, other);
    }


    public GenericMultiSet getDifference(GenericMultiSet other)
    {
        return GenericMultiSetService.getDifference(this, other);
    }


    public GenericMultiSet getDifference(GenericSet other)
    {
        return GenericMultiSetService.getDifference(this, other);
    }


    public GenericMultiSet getSum(OrionSet<Object> other)
    {
        return GenericMultiSetService.getSum(this, other);
    }


    public GenericMultiSet getSum(GenericMultiSet other)
    {
        return GenericMultiSetService.getSum(this, other);
    }


    public GenericMultiSet getSum(GenericSet other)
    {
        return GenericMultiSetService.getSum(this, other);
    }


    public boolean isSubset(GenericMultiSet other)
    {
        return GenericMultiSetService.isSubset(this, other);
    }


    public boolean isSubset(GenericSet other)
    {
        return GenericMultiSetService.isSubset(this, other);
    }


    public boolean isProperSubset(GenericMultiSet other)
    {
        return GenericMultiSetService.isProperSubset(this, other);
    }


    public boolean isProperSubset(GenericSet other)
    {
        return GenericMultiSetService.isProperSubset(this, other);
    }


    public List<Object> getAsList()
    {
        return getElements().getAsList();
    }


    public OrionList<Object> getAsOrionList()
    {
        return getElements().getAsOrionList();
    }


    public ANumber getSizeOfPowerset()
    {
        return ANumber.of(2).exponentiateGET(getSize());
    }


    public int getSizeOfPowersetAsInteger()
    {
        return ANumber.of(2).exponentiateGET(getSize()).getAsInt();
    }


    public boolean isDisjointTo(GenericMultiSet other)
    {
        return GenericMultiSetService.isDisjointTo(this, other);
    }


    public boolean isDisjointTo(GenericSet other)
    {
        return GenericMultiSetService.isDisjointTo(this, other);
    }


    public ANumber getCardinality()
    {
        return ANumber.of(getSize());
    }


    public Stream<Object> filter(Predicate<Object> filterToApply)
    {
        return getElements().filter(filterToApply);
    }


    public boolean findAny(Predicate<Object> filterToApply)
    {
        return getElements().findAny(filterToApply);
    }


    public void forAll(Consumer<Object> action)
    {
        getElements().forAll(action);
    }


    public void forAll(Stream<Object> stream, Consumer<Object> action)
    {
        getElements().forAll(stream, action);
    }


    public void filterAndLoop(Predicate<Object> filterToApply, Consumer<Object> action)
    {
        getElements().forAll(filter(filterToApply), action);
    }


    public void delete(Object element)
    {
        getElements().delete(element);
    }


    public void delete(GenericMultiSet other)
    {
        GenericSetRules.isValid(other);
        other.getElements().forEach(element -> getElements().delete(element));
    }


    public void deleteAll()
    {
        getElements().deleteAll();
    }


    public void append(Object element)
    {
        getElements().append(element);
    }


    public void append(OrionSet<Object> elements)
    {
        getElements().append(elements);
    }


    public void append(GenericMultiSet elements)
    {
        append(elements.getElements());
    }


    public void append(GenericSet elements)
    {
        append(elements.getElements());
    }


    public void append(Object[] elements)
    {
        getElements().append(elements);
    }


    public void append(List<Object> elements)
    {
        getElements().append(elements);
    }


    public void append(java.util.Set<Object> elements)
    {
        getElements().append(elements);
    }


    @Override
    public int hashCode()
    {
        return GenericMultiSetInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return GenericMultiSetInternalService.equals(this, object);
    }


    @Override
    public GenericMultiSet clone() throws CloneNotSupportedException
    {
        return (GenericMultiSet)CloningService.clone(this);
    }


    public GenericMultiSet getCopy()
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


    public OrionSet<Object> getElements()
    {
        return this.elements;
    }
}