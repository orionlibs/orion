package com.orion.math.graph.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.graph.vertex.object.ObjectVertex;
import com.orion.math.graph.vertex.point.PointVertex;

public class ContractEdgeOfGraphTask extends Orion
{
    public static Graph run(Graph graph, Edge edge)
    {
        GraphRules.isValid(graph);
        GraphRules.isEdgeInGraph(graph, edge);
        GraphType type = graph.getType();
        Graph newGraph = graph.subtractEdge(edge);
        OrionSet<Edge> edgesOfVertex1 = newGraph.getNeighbourEdgesOf(edge.getFirst());
        OrionSet<Edge> edgesOfVertex2 = newGraph.getNeighbourEdgesOf(edge.getSecond());
        OrionSet<Vertex> vertices = newGraph.getVerticesCopy();
        vertices.remove(edge.getFirst());
        vertices.remove(edge.getSecond());
        Vertex newVertex = null;

        if(type.is(GraphType.Number))
        {
            newVertex = NumberVertex.of();
        }
        else if(type.is(GraphType.Point))
        {
            newVertex = PointVertex.of();
        }
        else if(type.is(GraphType.Object))
        {
            newVertex = ObjectVertex.of();
        }

        vertices.add(newVertex);

        for(Edge edgeOfVertex1 : edgesOfVertex1)
        {
            Vertex first = null;
            Vertex second = null;

            if(edgeOfVertex1.getFirst().equals(edge.getFirst()))
            {

                if(type.is(GraphType.Number))
                {
                    first = NumberVertex.of();
                }
                else if(type.is(GraphType.Point))
                {
                    first = PointVertex.of();
                }
                else if(type.is(GraphType.Object))
                {
                    first = ObjectVertex.of();
                }

                second = edgeOfVertex1.getSecond();
            }
            else if(edgeOfVertex1.getSecond().equals(edge.getFirst()))
            {
                first = edgeOfVertex1.getFirst();

                if(type.is(GraphType.Number))
                {
                    second = NumberVertex.of();
                }
                else if(type.is(GraphType.Point))
                {
                    second = PointVertex.of();
                }
                else if(type.is(GraphType.Object))
                {
                    second = ObjectVertex.of();
                }

            }

            edgeOfVertex1.setVertices(first, second);
        }

        for(Edge edgeOfVertex2 : edgesOfVertex2)
        {
            Vertex first = null;
            Vertex second = null;

            if(edgeOfVertex2.getFirst().equals(edge.getFirst()))
            {

                if(type.is(GraphType.Number))
                {
                    first = NumberVertex.of();
                }
                else if(type.is(GraphType.Point))
                {
                    first = PointVertex.of();
                }
                else if(type.is(GraphType.Object))
                {
                    first = ObjectVertex.of();
                }

                second = edgeOfVertex2.getSecond();
            }
            else if(edgeOfVertex2.getSecond().equals(edge.getFirst()))
            {
                first = edgeOfVertex2.getFirst();

                if(type.is(GraphType.Number))
                {
                    second = NumberVertex.of();
                }
                else if(type.is(GraphType.Point))
                {
                    second = PointVertex.of();
                }
                else if(type.is(GraphType.Object))
                {
                    second = ObjectVertex.of();
                }

            }

            edgeOfVertex2.setVertices(first, second);
        }

        return Graph.of(vertices, newGraph.getEdges());
    }
}