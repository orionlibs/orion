package com.orion.math.graph.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;

public class SubtractVerticesFromGraphTask extends Orion
{
    public static Graph run(Graph graph, OrionSet<Vertex> verticesToDelete)
    {
        GraphRules.isValid(graph);
        VertexRules.areValid(verticesToDelete);
        OrionSet<Vertex> vertices = graph.getVertices().getDifference(verticesToDelete);
        OrionSet<Edge> edgesToDelete = OrionHashSet.<Edge>of();

        for(Edge edge : graph.getEdges())
        {

            for(Vertex vertex : verticesToDelete)
            {

                if(edge.isIncidentAt(vertex))
                {
                    edgesToDelete.add(edge);
                }

            }

        }

        OrionSet<Edge> edges = graph.getEdges().getDifference(edgesToDelete);
        return Graph.of(vertices.getCopy(), edges.getCopy());
    }
}