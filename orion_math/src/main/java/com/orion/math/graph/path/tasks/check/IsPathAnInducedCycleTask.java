package com.orion.math.graph.path.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.path.PathRules;

public class IsPathAnInducedCycleTask extends Orion
{
    public static boolean run(Path path, Graph graph)
    {
        PathRules.isValid(path);
        GraphRules.isValid(graph);
        boolean isInducedCycle = path.isCycle() && path.getGraph().isInducedSubgraphOf(graph);
        boolean hasChords = graph.getEdges().findAny(edge -> path.isChordOfCycle(edge));
        return isInducedCycle && !hasChords;
    }
}