package com.orion.math.set;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.number.ANumber;

public class TruthSet extends Set
{
    public TruthSet()
    {
        super();
    }


    public TruthSet(OrionSet<ANumber> elements)
    {
        super(elements);
    }


    public TruthSet(OrionList<ANumber> elements)
    {
        super(elements);
    }


    public static TruthSet of()
    {
        return new TruthSet();
    }


    public static TruthSet of(OrionSet<ANumber> elements)
    {
        return new TruthSet(elements);
    }


    public static TruthSet of(OrionList<ANumber> elements)
    {
        return new TruthSet(elements);
    }
}