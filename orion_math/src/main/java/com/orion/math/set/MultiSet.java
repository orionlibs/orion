package com.orion.math.set;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashMultiSet;
import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MultiSet extends Orion implements MathObject, Cloneable
{
    private OrionSet<ANumber> elements;


    public MultiSet()
    {
        this.elements = OrionHashMultiSet.<ANumber>of();
    }


    public MultiSet(OrionSet<ANumber> elements)
    {
        SetRules.isValid(elements);
        this.elements = OrionHashMultiSet.<ANumber>of(elements);
    }


    public MultiSet(List<ANumber> elements)
    {
        SetRules.isValid(elements);
        this.elements = OrionHashMultiSet.<ANumber>of(elements);
    }


    public static MultiSet of()
    {
        return new MultiSet();
    }


    public static MultiSet of(OrionSet<ANumber> elements)
    {
        return new MultiSet(elements);
    }


    public static MultiSet of(List<ANumber> elements)
    {
        return new MultiSet(elements);
    }


    public long getMultiplicityOfElement(ANumber x)
    {
        return getElements().getMultiplicityOfElement(x);
    }


    public int getSize()
    {
        SetRules.isNotEmpty(getElements());
        return getElements().getSize();
    }


    public boolean contains(ANumber element)
    {
        SetRules.isNotEmpty(getElements());
        return getElements().contains(element);
    }


    public boolean notContains(ANumber element)
    {
        return !getElements().contains(element);
    }


    public boolean containsValue(ANumber value)
    {
        return MultiSetService.containsValue(this, value);
    }


    public boolean notContainsValue(ANumber value)
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


    public MultiSet getUnion(OrionSet<ANumber> other)
    {
        return MultiSetService.getUnion(this, other);
    }


    public MultiSet getUnion(MultiSet other)
    {
        return MultiSetService.getUnion(this, other);
    }


    public MultiSet getUnion(Set other)
    {
        return MultiSetService.getUnion(this, other);
    }


    public MultiSet getIntersection(OrionSet<ANumber> other)
    {
        return MultiSetService.getIntersection(this, other);
    }


    public MultiSet getIntersection(Set other)
    {
        return MultiSetService.getIntersection(this, other);
    }


    public MultiSet getIntersection(MultiSet other)
    {
        return MultiSetService.getIntersection(this, other);
    }


    public MultiSet getDifference(OrionSet<ANumber> other)
    {
        return MultiSetService.getDifference(this, other);
    }


    public MultiSet getDifference(MultiSet other)
    {
        return MultiSetService.getDifference(this, other);
    }


    public MultiSet getDifference(Set other)
    {
        return MultiSetService.getDifference(this, other);
    }


    public MultiSet getSum(OrionSet<ANumber> other)
    {
        return MultiSetService.getSum(this, other);
    }


    public MultiSet getSum(MultiSet other)
    {
        return MultiSetService.getSum(this, other);
    }


    public MultiSet getSum(Set other)
    {
        return MultiSetService.getSum(this, other);
    }


    public boolean isSubset(MultiSet other)
    {
        return MultiSetService.isSubset(this, other);
    }


    public boolean isSubset(Set other)
    {
        return MultiSetService.isSubset(this, other);
    }


    public boolean isProperSubset(MultiSet other)
    {
        return MultiSetService.isProperSubset(this, other);
    }


    public boolean isProperSubset(Set other)
    {
        return MultiSetService.isProperSubset(this, other);
    }


    public List<ANumber> getAsList()
    {
        return getElements().getAsList();
    }


    public OrionList<ANumber> getAsOrionList()
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


    public boolean isDisjointTo(MultiSet other)
    {
        return MultiSetService.isDisjointTo(this, other);
    }


    public boolean isDisjointTo(Set other)
    {
        return MultiSetService.isDisjointTo(this, other);
    }


    public ANumber getCardinality()
    {
        return ANumber.of(getSize());
    }


    public ANumber getMinimum()
    {
        return ArithmeticService.getMinimum(getElements());
    }


    public ANumber getMaximum()
    {
        return ArithmeticService.getMaximum(getElements());
    }


    public boolean isBounded()
    {
        return MultiSetService.isBounded(this);
    }


    public Stream<ANumber> filter(Predicate<ANumber> filterToApply)
    {
        return getElements().filter(filterToApply);
    }


    public boolean findAny(Predicate<ANumber> filterToApply)
    {
        return getElements().findAny(filterToApply);
    }


    public void forAll(Consumer<ANumber> action)
    {
        getElements().forAll(action);
    }


    public void forAll(Stream<ANumber> stream, Consumer<ANumber> action)
    {
        getElements().forAll(stream, action);
    }


    public void filterAndLoop(Predicate<ANumber> filterToApply, Consumer<ANumber> action)
    {
        getElements().forAll(filter(filterToApply), action);
    }


    public void delete(ANumber element)
    {
        getElements().delete(element);
    }


    public void delete(MultiSet other)
    {
        SetRules.isValid(other);
        other.getElements().forEach(element -> getElements().delete(element));
    }


    public void deleteAll()
    {
        getElements().deleteAll();
    }


    public void append(ANumber element)
    {
        getElements().append(element);
    }


    public void append(OrionSet<ANumber> elements)
    {
        getElements().append(elements);
    }


    public void append(MultiSet elements)
    {
        append(elements.getElements());
    }


    public void append(Set elements)
    {
        append(elements.getElements());
    }


    public void append(ANumber[] elements)
    {
        getElements().append(elements);
    }


    public void append(List<ANumber> elements)
    {
        getElements().append(elements);
    }


    public void append(java.util.Set<ANumber> elements)
    {
        getElements().append(elements);
    }


    @Override
    public String toString()
    {
        return print();
    }


    public String print()
    {
        return MultiSetService.print(this);
    }


    @Override
    public int hashCode()
    {
        return MultiSetInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return MultiSetInternalService.equals(this, object);
    }


    @Override
    public MultiSet clone() throws CloneNotSupportedException
    {
        return (MultiSet)CloningService.clone(this);
    }


    public MultiSet getCopy()
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


    public OrionSet<ANumber> getElements()
    {
        return this.elements;
    }
}