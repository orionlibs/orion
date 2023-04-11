package com.orion.math.set.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashMultiSet;
import com.orion.math.number.ANumber;
import com.orion.math.set.MultiSet;
import com.orion.math.set.SetRules;

public class GetDifferenceOfMultiSetsTask extends Orion
{
    @SuppressWarnings(
    {"unchecked", "rawtypes"})
    public static MultiSet run(MultiSet set1, OrionSet<ANumber> set2)
    {
        SetRules.isValid(set1);
        SetRules.isValid(set2);
        OrionSet<ANumber> result = null;

        if(set2 instanceof OrionHashMultiSet)
        {
            result = ((OrionHashMultiSet<ANumber>)set1.getElements()).getDifference((OrionHashMultiSet)set2);
        }
        else
        {
            result = ((OrionHashMultiSet<ANumber>)set1.getElements()).getDifference(OrionHashMultiSet.of(set2));
        }

        return MultiSet.of(result);
    }
}