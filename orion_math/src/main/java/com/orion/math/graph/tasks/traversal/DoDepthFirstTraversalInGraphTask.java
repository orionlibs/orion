package com.orion.math.graph.tasks.traversal;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import java.util.function.Consumer;

public class DoDepthFirstTraversalInGraphTask extends Orion
{
    public static void run(Graph graph, Consumer<Vertex> action)
    {
        GraphRules.isValid(graph);
        run(graph, graph.getNonisolatedRandomVertex(), action);
    }


    public static void run(Graph graph, Vertex startVertex, Consumer<Vertex> action)
    {
        GraphRules.isValid(graph);
        GraphRules.isVertexInGraph(graph, startVertex);
        boolean[] visited = new boolean[graph.getNumberOfVertices()];
        process(graph.getVerticesAsList(), graph, startVertex, visited, action);
    }


    private static void process(OrionList<Vertex> vertices, Graph graph, Vertex startVertex, boolean[] visited, Consumer<Vertex> action)
    {
        visited[vertices.getIndexOf(startVertex)] = true;
        action.accept(startVertex);
        Edge[] edgesWithStartVertexAsFirst = graph.getEdgesThatIncludeVertexAsFirst(startVertex);

        for(Edge edge : edgesWithStartVertexAsFirst)
        {

            if(!visited[vertices.getIndexOf(edge.getSecond())])
            {
                process(vertices, graph, edge.getSecond(), visited, action);
            }

        }

    }
}