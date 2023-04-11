package com.orion.math.graph.path.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.path.PathRules;

public class PathEqualsTask extends Orion
{
    public static boolean run(Path x, Object y)
    {
        PathRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Path other = (Path)y;
            return x.getEdges().equals(other.getEdges());
        }

    }
}