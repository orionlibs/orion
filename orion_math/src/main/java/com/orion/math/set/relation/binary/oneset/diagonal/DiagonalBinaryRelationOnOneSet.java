package com.orion.math.set.relation.binary.oneset.diagonal;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.object.CloningService;
import com.orion.core.runnable.predicates.Condition;
import com.orion.core.tuple.Pair;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSet;

public class DiagonalBinaryRelationOnOneSet extends BinaryRelationOnOneSet
{
    public DiagonalBinaryRelationOnOneSet()
    {
        super();
    }


    public DiagonalBinaryRelationOnOneSet(OrionSet<Pair<Object, Object>> elements, OrionSet<Object> set, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        super(elements, set, conditionPairsMustSatisfy);
        DiagonalBinaryRelationOnOneSetRules.isValid(elements, set);
    }


    public DiagonalBinaryRelationOnOneSet(OrionSet<Object> set, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        super(set, conditionPairsMustSatisfy);
    }


    public static DiagonalBinaryRelationOnOneSet of()
    {
        return new DiagonalBinaryRelationOnOneSet();
    }


    public static DiagonalBinaryRelationOnOneSet of(OrionSet<Pair<Object, Object>> elements, OrionSet<Object> set, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        return new DiagonalBinaryRelationOnOneSet(elements, set, conditionPairsMustSatisfy);
    }


    public static DiagonalBinaryRelationOnOneSet of(OrionSet<Object> set, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        return new DiagonalBinaryRelationOnOneSet(set, conditionPairsMustSatisfy);
    }


    @Override
    public Function1x1<ANumber, ANumber> calculateFunctionForThisRelation()
    {
        return Function1x1.<ANumber, ANumber>of(x -> x);
    }


    @Override
    public int hashCode()
    {
        return DiagonalBinaryRelationOnOneSetInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return DiagonalBinaryRelationOnOneSetInternalService.equals(this, object);
    }


    @Override
    public DiagonalBinaryRelationOnOneSet clone() throws CloneNotSupportedException
    {
        return (DiagonalBinaryRelationOnOneSet)CloningService.clone(this);
    }


    public DiagonalBinaryRelationOnOneSet getCopy()
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
}