package com.orion.math.set.generic;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class GenericSet implements MathObject, Cloneable
{
    private OrionSet<Object> elements;


    public GenericSet()
    {
        this.elements = OrionHashSet.<Object>of();
    }


    public GenericSet(OrionSet<Object> elements)
    {
        GenericSetRules.isValid(elements);
        this.elements = elements;
    }


    public GenericSet(OrionList<Object> elements)
    {
        GenericSetRules.isValid(elements);
        this.elements = elements.getAsOrionSet();
    }


    public static GenericSet of()
    {
        return new GenericSet();
    }


    public static GenericSet of(OrionSet<Object> elements)
    {
        return new GenericSet(elements);
    }


    public static GenericSet of(OrionList<Object> elements)
    {
        return new GenericSet(elements);
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
        return GenericSetService.containsValue(this, value);
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


    public GenericSet getUnion(OrionSet<Object> other)
    {
        GenericSet newSet = getCopy();
        newSet.append(other);
        return newSet;
    }


    public void unionise(OrionSet<Object> other)
    {
        append(other);
    }


    public GenericSet getUnion(GenericSet other)
    {
        GenericSet newSet = getCopy();
        newSet.append(other);
        return newSet;
    }


    public void unionise(GenericSet other)
    {
        append(other);
    }


    public GenericSet getIntersection(OrionSet<Object> other)
    {
        return GenericSetService.getIntersection(this, other);
    }


    public GenericSet getIntersection(GenericSet other)
    {
        return GenericSetService.getIntersection(this, other);
    }


    public GenericSet getDifference(OrionSet<Object> other)
    {
        return GenericSetService.getDifference(this, other);
    }


    public GenericSet getDifference(GenericSet other)
    {
        return GenericSetService.getDifference(this, other);
    }


    public boolean isSubset(GenericSet other)
    {
        return GenericSetService.isSubset(this, other);
    }


    public boolean isProperSubset(GenericSet other)
    {
        return GenericSetService.isProperSubset(this, other);
    }


    public List<Object> getAsList()
    {
        return new ArrayList<Object>(getElements());
    }


    public ANumber getSizeOfPowerset()
    {
        return ANumber.of(2).exponentiateGET(getSize());
    }


    public int getSizeOfPowersetAsInteger()
    {
        return ANumber.of(2).exponentiateGET(getSize()).getAsInt();
    }


    public GenericSet getPowerset()
    {
        return GenericSetService.getPowerset(this);
    }


    public boolean isDisjointTo(GenericSet other)
    {
        return GenericSetService.isDisjointTo(this, other);
    }


    public GenericSet getComplementRelativeTo(GenericSet other)
    {
        return GenericSetService.getComplementRelativeTo(this, other);
    }


    public GenericSet getSymmetricDifference(GenericSet other)
    {
        return GenericSetService.getSymmetricDifference(this, other);
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


    public void delete(GenericSet other)
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
        return GenericSetInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return GenericSetInternalService.equals(this, object);
    }


    @Override
    public GenericSet clone() throws CloneNotSupportedException
    {
        return (GenericSet)CloningService.clone(this);
    }


    public GenericSet getCopy()
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