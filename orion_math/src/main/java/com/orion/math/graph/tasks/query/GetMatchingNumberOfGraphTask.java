package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.combinatorics.CombinatoricsService;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.number.ANumber;
import java.util.List;

public class GetMatchingNumberOfGraphTask extends Orion
{
    public static ANumber run(Graph graph)
    {
        GraphRules.isThereAtLeastOneEdge(graph);
        int maximumNumberOfEdgesFormingAMatching = -1;

        for(int i = 1; i <= graph.getNumberOfEdges(); i++)
        {
            List<List<Edge>> combinationsOfEdges = CombinatoricsService.getCombinationsWithoutElementRepetition(graph.getEdgesAsList(), i);
            OrionSet<Edge> edges = OrionHashSet.<Edge>of(combinationsOfEdges.get(0));

            if(graph.isAMatching(edges) && edges.size() > maximumNumberOfEdgesFormingAMatching)
            {
                maximumNumberOfEdgesFormingAMatching = edges.size();
            }

        }

        return ANumber.of(maximumNumberOfEdgesFormingAMatching);
    }
}