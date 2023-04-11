package com.orion.math.function.tasks.roots;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.util.Set;

public class KeepUniqueRootsOfFunctionTask extends Orion
{
    public static OrionSet<ANumber> run(Set<ANumber> tempRoots, ANumber EPS)
    {
        OrionSet<ANumber> roots = OrionHashSet.<ANumber>of();
        OrionList<ANumber> rootsList = OrionArrayList.<ANumber>of(tempRoots);

        for(int i = 0; i < rootsList.size() - 1; i++)
        {

            for(int j = i + 1; j < rootsList.size(); j++)
            {

                if(rootsList.get(i).subtractGET(rootsList.get(j)).getAbsoluteValue().isLessThanOrEqual(EPS))
                {
                    ANumber maximum = ArithmeticService.getMaximum(rootsList.get(i), rootsList.get(j));
                    boolean foundRootInSet = false;

                    for(ANumber temp : roots)
                    {

                        if(temp.subtractGET(maximum).getAbsoluteValue().isLessThanOrEqual(EPS))
                        {
                            foundRootInSet = true;
                            break;
                        }

                    }

                    if(!foundRootInSet)
                    {
                        roots.add(maximum);
                    }

                }

            }

        }

        return roots;
    }
}