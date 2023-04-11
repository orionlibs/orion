package com.orion.math.set;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1xN;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Set extends Orion implements MathObject, Cloneable
{
    private OrionSet<ANumber> elements;


    public Set()
    {
        this.elements = OrionHashSet.<ANumber>of();
    }


    public Set(OrionSet<ANumber> elements)
    {
        SetRules.isValid(elements);
        this.elements = elements;
    }


    public Set(OrionList<ANumber> elements)
    {
        SetRules.isValid(elements);
        this.elements = elements.getAsOrionSet();
    }


    public static Set of()
    {
        return new Set();
    }


    public static Set of(OrionSet<ANumber> elements)
    {
        return new Set(elements);
    }


    public static Set of(OrionList<ANumber> elements)
    {
        return new Set(elements);
    }


    public static Set ofGeneratingFunction(Function1xN<ANumber, ANumber> generatingFunction, ANumber initialFunctionInput)
    {
        FunctionRules.isValid(generatingFunction);
        return new Set(OrionArrayList.<ANumber>of(generatingFunction.run(initialFunctionInput)));
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
        return SetService.containsValue(this, value);
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


    public Set getUnion(OrionSet<ANumber> other)
    {
        Set newSet = getCopy();
        newSet.append(other);
        return newSet;
    }


    public void unionise(OrionSet<ANumber> other)
    {
        append(other);
    }


    public Set getUnion(Set other)
    {
        Set newSet = getCopy();
        newSet.append(other);
        return newSet;
    }


    public void unionise(Set other)
    {
        append(other);
    }


    public Set getIntersection(OrionSet<ANumber> other)
    {
        return SetService.getIntersection(this, other);
    }


    public Set getIntersection(Set other)
    {
        return SetService.getIntersection(this, other);
    }


    public Set getDifference(OrionSet<ANumber> other)
    {
        return SetService.getDifference(this, other);
    }


    public Set getDifference(Set other)
    {
        return SetService.getDifference(this, other);
    }


    public boolean isSubset(Set other)
    {
        return SetService.isSubset(this, other);
    }


    public boolean isProperSubset(Set other)
    {
        return SetService.isProperSubset(this, other);
    }


    public TruthSet getTruthSetFor(Predicate<ANumber> filterToApply)
    {
        return SetService.getTruthSetFor(this, filterToApply);
    }


    public List<ANumber> getAsList()
    {
        return new ArrayList<ANumber>(getElements());
    }


    public OrionList<ANumber> getAsOrionList()
    {
        return OrionArrayList.<ANumber>of(getElements());
    }


    public ANumber getSizeOfPowerset()
    {
        return ANumber.of(2).exponentiateGET(getSize());
    }


    public int getSizeOfPowersetAsInteger()
    {
        return ANumber.of(2).exponentiateGET(getSize()).getAsInt();
    }


    public Set getPowerset()
    {
        return SetService.getPowerset(this);
    }


    public boolean isDisjointTo(Set other)
    {
        return SetService.isDisjointTo(this, other);
    }


    public Set getComplementRelativeTo(Set other)
    {
        return SetService.getComplementRelativeTo(this, other);
    }


    public Set getSymmetricDifference(Set other)
    {
        return SetService.getSymmetricDifference(this, other);
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
        return SetService.isBounded(this);
    }


    public ANumber getNumberOfSubsetsTheSetHas()
    {
        return ANumber.of(2).exponentiateGET(getCardinality());
    }


    public ANumber getNumberOfDerangements()
    {
        return SetService.getNumberOfDerangements(this);
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


    public void delete(Set other)
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
        return SetService.print(this);
    }


    @Override
    public int hashCode()
    {
        return SetInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return SetInternalService.equals(this, object);
    }


    @Override
    public Set clone() throws CloneNotSupportedException
    {
        return (Set)CloningService.clone(this);
    }


    public Set getCopy()
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