package com.orion.math.graph.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.OrionSetService;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;

public class AreGraphVerticesIndependentTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static boolean run(Graph graph, OrionSet<Vertex> vertices)
    {
        GraphRules.isValid(graph);
        GraphRules.areVerticesInGraph(graph, vertices);
        OrionList<Vertex> verticesList = vertices.getAsOrionList();
        return !verticesList.findAnyInPairsCountedOnce((i, j) ->
        {
            Edge[] edges1 = graph.getEdgesThatIncludeVertex(verticesList.get(i));
            Edge[] edges2 = graph.getEdgesThatIncludeVertex(verticesList.get(j));
            OrionSet<Edge> edgesSet1 = OrionHashSet.<Edge>of(edges1);
            OrionSet<Edge> edgesSet2 = OrionHashSet.<Edge>of(edges2);
            return OrionSetService.getIntersection(edgesSet1, edgesSet2).getSize() > 0;
        });
    }
}