package com.orion.math.graph;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.MathObject;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeService;
import com.orion.math.graph.tasks.BuildEdgesFromAdjacencyMatrixForGraphTask;
import com.orion.math.graph.tasks.GraphEqualsTask;
import com.orion.math.graph.tasks.GraphHashCodeTask;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.linearalgebra.matrix.Matrix;
import java.util.List;
import java.util.Map;

class GraphInternalService implements MathObject
{
    static boolean equals(Graph x, Object y)
    {
        return GraphEqualsTask.run(x, y);
    }


    static int hashCode(Graph x)
    {
        return GraphHashCodeTask.run(x);
    }


    static OrionSet<Edge> buildEdgesFromAdjacencyList(GraphType graphType, Map<Vertex, List<Vertex>> adjacencyList)
    {
        OrionSet<Edge> newEdges = OrionHashSet.of();
        adjacencyList.entrySet().stream()
                        .forEach(entry -> entry.getValue()
                                        .forEach(v -> newEdges.add(EdgeService.createEdgeBetween(graphType, entry.getKey(), v))));
        return newEdges;
    }


    static OrionSet<Edge> buildEdgesFromAdjacencyMatrix(GraphType graphType, OrionSet<Vertex> vertices, Matrix adjacencyMatrix)
    {
        return BuildEdgesFromAdjacencyMatrixForGraphTask.run(graphType, vertices, adjacencyMatrix);
    }
}