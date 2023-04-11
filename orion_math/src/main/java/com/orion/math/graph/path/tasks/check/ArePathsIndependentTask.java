package com.orion.math.graph.path.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.OrionSetService;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.path.PathRules;
import com.orion.math.graph.vertex.Vertex;
import java.util.stream.IntStream;

public class ArePathsIndependentTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static boolean run(Path... paths)
    {
        PathRules.areValid(paths);
        PathRules.doPathsHaveSameType(paths);
        OrionSet<Vertex>[] innerVertexSets = new OrionHashSet[paths.length];
        IntStream.range(0, paths.length).forEach(i -> innerVertexSets[i] = paths[i].getInnerVerticesAsSet());
        return OrionSetService.getIntersection(innerVertexSets).isEmpty();
    }


    public static boolean run(OrionSet<Path> paths)
    {
        return run(paths.getAsArray());
    }
}