package com.orion.math.set.relation.binary.oneset.equivalenceclass;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.object.CloningService;
import com.orion.math.MathObject;

public class EquivalenceClass extends Orion implements MathObject, Cloneable
{
    private Object representativeElement;
    private OrionSet<Object> set;


    public EquivalenceClass(Object representativeElement, OrionSet<Object> set)
    {
        EquivalenceClassRules.isValid(representativeElement, set);
        this.representativeElement = representativeElement;
        this.set = set;
    }


    public static EquivalenceClass of(Object representativeElement, OrionSet<Object> set)
    {
        return new EquivalenceClass(representativeElement, set);
    }


    public boolean doesElementBelongToEquivalenceClass(Object element)
    {
        return getSet().findAny(p -> p.equals(element));
    }


    public boolean doesPairNotBelongToRelation(Object element)
    {
        return !doesElementBelongToEquivalenceClass(element);
    }


    public int getSize()
    {
        return getSet().getSize();
    }


    public boolean isEmpty()
    {
        return getSet().isEmpty();
    }


    public boolean isNotEmpty()
    {
        return !getSet().isEmpty();
    }


    @Override
    public int hashCode()
    {
        return EquivalenceClassInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return EquivalenceClassInternalService.equals(this, object);
    }


    @Override
    public EquivalenceClass clone() throws CloneNotSupportedException
    {
        return (EquivalenceClass)CloningService.clone(this);
    }


    public EquivalenceClass getCopy()
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


    public OrionSet<Object> getSet()
    {
        return this.set;
    }


    public Object getRepresentativeElement()
    {
        return this.representativeElement;
    }
}