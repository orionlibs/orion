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

public class IsGraphLEdgeConnectedTask extends Orion
{
    public static boolean run(Graph graph, ANumber l)
    {
        GraphRules.isValid(graph);
        NumberRules.hasNaturalNumberValue(l);

        if(graph.getOrder().isGreaterThan(1))
        {
            Stream<Graph> subgraphsWithLessThanLEdges = graph.getAllPossibleSubgraphsAsList().filter(g -> g.getNumberOfEdgesAsNumber().isLessThan(l));
            OrionList<Graph> subgraphs = OrionArrayList.of(OrionStream.getAsList(subgraphsWithLessThanLEdges));
            return !subgraphs.findAny(subgraph -> graph.subtractEdges(subgraph.getEdges()).isNotConnected());
        }
        else
        {
            return false;
        }

    }
}