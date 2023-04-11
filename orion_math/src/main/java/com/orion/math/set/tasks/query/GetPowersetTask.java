package com.orion.math.set.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.number.ANumber;
import com.orion.math.set.Set;
import com.orion.math.set.SetRules;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GetPowersetTask extends Orion
{
    public static Set run(Set set)
    {
        SetRules.isValid(set);
        List<ANumber> setTemp = set.getAsList();
        int sizeOfPowerset = set.getSizeOfPowersetAsInteger();
        Set newSet = Set.of();

        for(AtomicInteger i = new AtomicInteger(0); i.intValue() < sizeOfPowerset; i.incrementAndGet())
        {
            OrionSet<ANumber> newElements = OrionHashSet.of();
            IntStream.range(0, setTemp.size()).filter(j -> (i.intValue() & (1 << j)) > 0)
                            .forEach(j -> newElements.add(setTemp.get(j).getCopy()));
            newSet.append(newElements);
        }

        return newSet;
    }
}