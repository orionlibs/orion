package com.orion.math.set.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.set.MultiSet;
import com.orion.math.set.Set;
import com.orion.math.set.SetRules;
import java.util.List;

public class SetPrintTask extends Orion
{
    public String run(Set set)
    {
        SetRules.isValid(set);
        StringBuilder result = new StringBuilder("{");
        result = printLeafElements(set.getAsList(), result);
        return result.append("}").toString();
    }


    public String run(MultiSet set)
    {
        SetRules.isValid(set);
        StringBuilder result = new StringBuilder("{");
        result = printLeafElements(set.getAsList(), result);
        return result.append("}").toString();
    }


    private StringBuilder printLeafElements(List<ANumber> set, StringBuilder result)
    {

        for(int i = 0; i < set.size(); i++)
        {
            result.append(set.get(i).print());

            if(i < set.size() - 1)
            {
                result.append(", ");
            }

        }

        return result;
    }
}