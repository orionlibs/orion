package com.orion.math.graph.path;

import com.orion.math.MathObject;
import com.orion.math.graph.path.tasks.PathEqualsTask;
import com.orion.math.graph.path.tasks.PathHashCodeTask;

class PathInternalService implements MathObject
{
    static boolean equals(Path x, Object y)
    {
        return PathEqualsTask.run(x, y);
    }


    static int hashCode(Path x)
    {
        return PathHashCodeTask.run(x);
    }
}