package com.orion.math.graph.path.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.path.PathRules;

public class IsPathIndependentFromAnotherTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static boolean run(Path path, Path other)
    {
        PathRules.areValid(path, other);
        PathRules.doPathsHaveSameType(path, other);
        boolean haveCommonEnds = path.getFirstVertex().equals(other.getFirstVertex())
                        && path.getLastVertex().equals(other.getLastVertex());
        return haveCommonEnds && path.getInnerVerticesAsSet().getIntersection(other.getInnerVerticesAsSet()).isEmpty();
    }
}