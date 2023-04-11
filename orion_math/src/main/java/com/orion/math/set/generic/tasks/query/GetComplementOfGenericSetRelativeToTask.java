package com.orion.math.set.generic.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.set.generic.GenericSet;
import com.orion.math.set.generic.GenericSetRules;
import java.util.List;

public class GetComplementOfGenericSetRelativeToTask extends Orion
{
    public static GenericSet run(GenericSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set1, set2);

        if(set1.isSubset(set2))
        {
            List<Object> set2Temp = set2.getAsList();
            set2Temp.removeAll(set1.getAsList());
            return GenericSet.of(OrionArrayList.of(set2Temp));
        }

        return GenericSet.of();
    }
}