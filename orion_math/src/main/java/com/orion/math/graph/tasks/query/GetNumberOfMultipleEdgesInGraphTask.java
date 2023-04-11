package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.number.ANumber;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class GetNumberOfMultipleEdgesInGraphTask extends Orion
{
    public static ANumber run(Graph graph)
    {
        GraphRules.isValid(graph);
        OrionList<Edge> edges = graph.getEdges().getAsOrionList();
        AtomicLong numberOfMultipleEdges = new AtomicLong();
        Set<Integer> iIndices = new HashSet<Integer>();
        edges.forAllPairsCountedOnce((i, j) ->
        {

            if(edges.get(i).equals(edges.get(j)))
            {
                iIndices.add(i);
                numberOfMultipleEdges.incrementAndGet();
            }

        });
        return ANumber.of(numberOfMultipleEdges.get() + iIndices.size());
    }
}