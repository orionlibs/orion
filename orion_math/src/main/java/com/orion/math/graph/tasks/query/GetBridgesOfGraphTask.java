package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.stream.OrionStream;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import java.util.ArrayList;
import java.util.List;

public class GetBridgesOfGraphTask extends Orion
{
    public static Edge[] run(Graph graph)
    {
        GraphRules.isValid(graph);
        List<Edge> bridges = new ArrayList<Edge>();

        for(Graph component : graph.getComponents())
        {
            OrionSet<Edge> edges = component.getEdgesCopy();
            bridges.addAll(OrionStream.getAsList(edges.filter(e -> graph.isBridge(component, e))));
        }

        return bridges.toArray(new Edge[0]);
    }
}