package com.orion.math.graph.edge.tasks.combination;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.number.NumberEdge;
import com.orion.math.graph.edge.object.ObjectEdge;
import com.orion.math.graph.edge.point.PointEdge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;
import com.orion.math.graph.vertex.Vertices;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.graph.vertex.object.ObjectVertex;
import com.orion.math.graph.vertex.point.PointVertex;

public class GetAllPossibleUndirectedEdgesOfGraphTask extends Orion
{
    public static OrionSet<Edge> run(OrionSet<Vertex> vertices)
    {
        VertexRules.areValid(vertices);
        GraphType graphType = Vertices.getType(vertices);
        OrionSet<Edge> edges = OrionHashSet.<Edge>of();
        OrionList<Vertex> verticesTemp = vertices.getAsOrionList();
        verticesTemp.forAllPairsCountedOnce((i, j) ->
        {

            if(graphType.is(GraphType.Number))
            {
                edges.add(NumberEdge.of((NumberVertex)verticesTemp.get(i), (NumberVertex)verticesTemp.get(j)));
            }
            else if(graphType.is(GraphType.Point))
            {
                edges.add(PointEdge.of((PointVertex)verticesTemp.get(i), (PointVertex)verticesTemp.get(j)));
            }
            else
            {
                edges.add(ObjectEdge.of((ObjectVertex)verticesTemp.get(i), (ObjectVertex)verticesTemp.get(j)));
            }

        });
        return edges;
    }
}