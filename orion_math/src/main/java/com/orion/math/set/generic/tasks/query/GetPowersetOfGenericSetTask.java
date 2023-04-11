package com.orion.math.set.generic.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.math.set.generic.GenericSet;
import com.orion.math.set.generic.GenericSetRules;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GetPowersetOfGenericSetTask extends Orion
{
    public static GenericSet run(GenericSet set)
    {
        GenericSetRules.isValid(set);
        List<Object> setTemp = set.getAsList();
        int sizeOfPowerset = set.getSizeOfPowersetAsInteger();
        GenericSet newSet = GenericSet.of();

        for(AtomicInteger i = new AtomicInteger(0); i.intValue() < sizeOfPowerset; i.incrementAndGet())
        {
            OrionSet<Object> newElements = OrionHashSet.<Object>of();
            IntStream.range(0, setTemp.size()).filter(j -> (i.intValue() & (1 << j)) > 0)
                            .forEach(j -> newElements.add(CloningService.clone(setTemp.get(j))));
            newSet.append(newElements);
        }

        return newSet;
    }
}