package com.orion.math.set.cartesianproduct;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.core.tuple.NTuple;
import com.orion.math.MathObject;

public class CartesianProduct implements MathObject, Cloneable
{
    private OrionSet<NTuple> elements;
    private OrionList<OrionSet<Object>> sets;


    public CartesianProduct()
    {
        this.elements = OrionHashSet.<NTuple>of();
        this.sets = OrionArrayList.<OrionSet<Object>>of();
    }


    public CartesianProduct(OrionSet<NTuple> elements)
    {
        CartesianProductRules.isValid(elements);
        this.elements = elements;
        constructSets(elements);
    }


    public static CartesianProduct of()
    {
        return new CartesianProduct();
    }


    public static CartesianProduct of(OrionSet<NTuple> elements)
    {
        return new CartesianProduct(elements);
    }


    private void constructSets(OrionSet<NTuple> elements)
    {
        OrionList<NTuple> elementsTemp = OrionArrayList.<NTuple>of(elements);
        int nTupleSize = elementsTemp.get(0).getSize();
        OrionList<OrionSet<Object>> setsTemp = OrionArrayList.<OrionSet<Object>>of();

        for(int i = 0; i < nTupleSize; i++)
        {
            OrionSet<Object> setI = OrionHashSet.<Object>of();

            for(int j = 0; j < elementsTemp.size(); j++)
            {
                setI.append(elementsTemp.get(j).get(i));
            }

            setsTemp.append(setI);
        }

        this.sets = setsTemp;
    }


    public boolean doesPairBelongToCartesianProduct(NTuple nTuple)
    {
        return getElements().findAny(tuple -> tuple.equals(nTuple));
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
        return CartesianProductInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return CartesianProductInternalService.equals(this, object);
    }


    @Override
    public CartesianProduct clone() throws CloneNotSupportedException
    {
        return (CartesianProduct)CloningService.clone(this);
    }


    public CartesianProduct getCopy()
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


    public OrionSet<NTuple> getElements()
    {
        return this.elements;
    }


    public OrionList<OrionSet<Object>> getSets()
    {
        return this.sets;
    }
}