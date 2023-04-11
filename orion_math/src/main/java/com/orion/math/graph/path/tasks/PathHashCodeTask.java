package com.orion.math.graph.path.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.path.PathRules;

public class PathHashCodeTask extends Orion
{
    public static int run(Path x)
    {
        PathRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getEdges().hashCode();
    }
}