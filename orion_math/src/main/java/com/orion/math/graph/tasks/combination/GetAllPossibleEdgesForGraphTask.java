package com.orion.math.graph.tasks.combination;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.number.NumberEdge;
import com.orion.math.graph.edge.object.ObjectEdge;
import com.orion.math.graph.edge.point.PointEdge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.graph.vertex.object.ObjectVertex;
import com.orion.math.graph.vertex.point.PointVertex;
import java.util.ArrayList;
import java.util.List;

public class GetAllPossibleEdgesForGraphTask extends Orion
{
    public static List<Edge> run(Graph graph)
    {
        GraphRules.isValid(graph);
        List<Edge> edges = new ArrayList<>();
        OrionList<Vertex> vertices = graph.getVertices().getAsOrionList();
        vertices.forAllPairsExceptSelf((Integer i, Integer j) ->
        {

            if(graph.getType().is(GraphType.Number))
            {
                edges.add(NumberEdge.of((NumberVertex)vertices.get(i), (NumberVertex)vertices.get(j)));
                edges.add(NumberEdge.of((NumberVertex)vertices.get(j), (NumberVertex)vertices.get(i)));
            }
            else if(graph.getType().is(GraphType.Point))
            {
                edges.add(PointEdge.of((PointVertex)vertices.get(i), (PointVertex)vertices.get(j)));
                edges.add(PointEdge.of((PointVertex)vertices.get(j), (PointVertex)vertices.get(i)));
            }
            else if(graph.getType().is(GraphType.Object))
            {
                edges.add(ObjectEdge.of((ObjectVertex)vertices.get(i), (ObjectVertex)vertices.get(j)));
                edges.add(ObjectEdge.of((ObjectVertex)vertices.get(j), (ObjectVertex)vertices.get(i)));
            }
            else
            {
                edges.add(ObjectEdge.of((ObjectVertex)vertices.get(i), (ObjectVertex)vertices.get(j)));
                edges.add(ObjectEdge.of((ObjectVertex)vertices.get(j), (ObjectVertex)vertices.get(i)));
            }

        });
        return edges;
    }
}