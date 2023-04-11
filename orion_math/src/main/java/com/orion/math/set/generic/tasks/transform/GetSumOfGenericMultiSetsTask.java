package com.orion.math.set.generic.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashMultiSet;
import com.orion.math.set.generic.GenericMultiSet;
import com.orion.math.set.generic.GenericSetRules;

public class GetSumOfGenericMultiSetsTask extends Orion
{
    @SuppressWarnings(
    {"unchecked", "rawtypes"})
    public static GenericMultiSet run(GenericMultiSet set1, OrionSet<Object> set2)
    {
        GenericSetRules.isValid(set1);
        GenericSetRules.isValid(set2);
        OrionSet<Object> result = null;

        if(set2 instanceof OrionHashMultiSet)
        {
            result = ((OrionHashMultiSet<Object>)set1.getElements()).getSum((OrionHashMultiSet)set2);
        }
        else
        {
            result = ((OrionHashMultiSet<Object>)set1.getElements()).getSum(OrionHashMultiSet.of(set2));
        }

        return GenericMultiSet.of(result);
    }
}