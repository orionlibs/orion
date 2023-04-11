package com.orion.math.set.cartesianproduct.pair;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.number.ANumber;

public class CartesianProductOfPairs implements MathObject, Cloneable
{
    private OrionSet<Pair<ANumber, ANumber>> elements;
    private OrionSet<ANumber> setA;
    private OrionSet<ANumber> setB;


    public CartesianProductOfPairs()
    {
        this.elements = OrionHashSet.<Pair<ANumber, ANumber>>of();
        this.setA = OrionHashSet.<ANumber>of();
        this.setB = OrionHashSet.<ANumber>of();
    }


    public CartesianProductOfPairs(OrionSet<Pair<ANumber, ANumber>> elements)
    {
        CartesianProductOfPairsRules.isValid(elements);
        this.elements = elements;
        this.setA = OrionHashSet.<ANumber>of(elements.mapToSet(pair -> pair.getFirst()));
        this.setB = OrionHashSet.<ANumber>of(elements.mapToSet(pair -> pair.getSecond()));
    }


    public static CartesianProductOfPairs of()
    {
        return new CartesianProductOfPairs();
    }


    public static CartesianProductOfPairs of(OrionSet<Pair<ANumber, ANumber>> elements)
    {
        return new CartesianProductOfPairs(elements);
    }


    public boolean doesPairBelongToCartesianProduct(Pair<ANumber, ANumber> pair)
    {
        return getElements().findAny(p -> p.equals(pair));
    }


    public int getSize()
    {
        return getElements().getSize();
    }


    public boolean isEmpty()
    {
        return getElements().isEmpty();
    }


    public boolean isNotEmpty()
    {
        return !getElements().isEmpty();
    }


    @Override
    public int hashCode()
    {
        return CartesianProductOfPairsInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return CartesianProductOfPairsInternalService.equals(this, object);
    }


    @Override
    public CartesianProductOfPairs clone() throws CloneNotSupportedException
    {
        return (CartesianProductOfPairs)CloningService.clone(this);
    }


    public CartesianProductOfPairs getCopy()
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


    public OrionSet<Pair<ANumber, ANumber>> getElements()
    {
        return this.elements;
    }


    public OrionSet<ANumber> getSetA()
    {
        return this.setA;
    }


    public OrionSet<ANumber> getSetB()
    {
        return this.setB;
    }
}