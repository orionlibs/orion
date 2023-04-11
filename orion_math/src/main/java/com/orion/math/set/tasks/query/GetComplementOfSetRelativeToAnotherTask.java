package com.orion.math.set.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.number.ANumber;
import com.orion.math.set.Set;
import com.orion.math.set.SetRules;
import java.util.List;

public class GetComplementOfSetRelativeToAnotherTask extends Orion
{
    public static Set run(Set set1, Set set2)
    {
        SetRules.isValid(set1, set2);

        if(set1.isSubset(set2))
        {
            List<ANumber> set2Temp = set2.getAsList();
            set2Temp.removeAll(set1.getAsList());
            return Set.of(OrionArrayList.of(set2Temp));
        }

        return Set.of();
    }
}