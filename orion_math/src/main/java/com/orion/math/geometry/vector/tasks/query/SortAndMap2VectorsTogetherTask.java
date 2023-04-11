package com.orion.math.geometry.vector.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class SortAndMap2VectorsTogetherTask extends Orion
{
    public static Pair<Vector, Vector> run(Vector x, Vector y)
    {
        VectorRules.doVectorSizesMatch(x, y);
        Map<ANumber, ANumber> mapperTemp = new HashMap<ANumber, ANumber>();
        IntStream.range(0, x.getDimensions()).forEach(i -> mapperTemp.put(x.get(i), y.get(i)));
        SortedMap<ANumber, ANumber> mapper = new TreeMap<ANumber, ANumber>(mapperTemp);
        ANumber[] xValuesSorted = new ANumber[x.getDimensions()];
        ANumber[] yValuesSorted = new ANumber[y.getDimensions()];
        int i = 0;

        for(Map.Entry<ANumber, ANumber> entry : mapper.entrySet())
        {
            xValuesSorted[i] = entry.getKey();
            yValuesSorted[i] = entry.getValue();
            ++i;
        }

        return Pair.of(Vector.of(xValuesSorted), Vector.of(yValuesSorted));
    }
}