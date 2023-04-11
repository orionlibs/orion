package com.orion.math.graph.tasks.traversal;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import java.util.LinkedList;
import java.util.function.Consumer;

public class DoBreadthFirstTraversalInGraphTask extends Orion
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
        LinkedList<Vertex> queue = new LinkedList<Vertex>();
        process(graph.getVerticesAsList(), graph, startVertex.getCopy(), visited, queue, action);
    }


    private static void process(OrionList<Vertex> vertices, Graph graph, Vertex startVertex, boolean[] visited, LinkedList<Vertex> queue, Consumer<Vertex> action)
    {
        visited[vertices.getIndexOf(startVertex)] = true;
        action.accept(startVertex);
        queue.add(startVertex);

        while(!queue.isEmpty())
        {
            startVertex = queue.poll().getCopy();
            Edge[] edgesWithStartVertexAsFirst = graph.getEdgesThatIncludeVertexAsFirst(startVertex);

            for(Edge edge : edgesWithStartVertexAsFirst)
            {
                int indexOfSecond = vertices.getIndexOf(edge.getSecond());

                if(!visited[indexOfSecond])
                {
                    visited[indexOfSecond] = true;
                    action.accept(edge.getSecond());
                    queue.add(edge.getSecond());
                }

            }

        }

    }
}