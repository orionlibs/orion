package com.orion.math.graph.edge.tasks.combination;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeService;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;
import com.orion.math.graph.vertex.Vertices;

public class GetAllPossibleDirectedEdgesOfGraphTask extends Orion
{
    public static OrionSet<Edge> run(OrionSet<Vertex> vertices)
    {
        VertexRules.areValid(vertices);
        GraphType graphType = Vertices.getType(vertices);
        OrionSet<Edge> edges = OrionHashSet.<Edge>of();
        OrionList<Vertex> verticesTemp = vertices.getAsOrionList();
        verticesTemp.forAllPairs((i, j) ->
        {
            edges.add(EdgeService.createEdgeBetween(graphType, verticesTemp.get(i), verticesTemp.get(j)));
        });
        return edges;
    }
}