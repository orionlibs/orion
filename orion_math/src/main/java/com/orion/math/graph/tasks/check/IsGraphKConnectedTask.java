package com.orion.math.graph.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.stream.OrionStream;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.stream.Stream;

public class IsGraphKConnectedTask extends Orion
{
    public static boolean run(Graph graph, ANumber k)
    {
        GraphRules.isValid(graph);
        NumberRules.hasNaturalNumberValue(k);

        if(graph.getOrder().isGreaterThan(k))
        {
            Stream<Graph> subgraphsWithOrderLessThanK = graph.getAllPossibleSubgraphsAsList().filter(g -> g.getOrder().isLessThan(k));
            OrionList<Graph> subgraphs = OrionArrayList.of(OrionStream.getAsList(subgraphsWithOrderLessThanK));
            return !subgraphs.findAny(subgraph -> graph.subtract(subgraph.getVertices()).isNotConnected());
        }
        else
        {
            return false;
        }

    }
}