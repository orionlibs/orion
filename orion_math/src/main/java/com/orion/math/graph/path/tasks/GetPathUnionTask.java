package com.orion.math.graph.path.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.number.NumberEdge;
import com.orion.math.graph.edge.object.ObjectEdge;
import com.orion.math.graph.edge.point.PointEdge;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.path.PathRules;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.graph.vertex.object.ObjectVertex;
import com.orion.math.graph.vertex.point.PointVertex;

public class GetPathUnionTask extends Orion
{
    public static Path run(Path path, Path other, Vertex connectingVertex)
    {
        PathRules.areValid(path, other);
        PathRules.doPathsHaveSameType(path, other);
        VertexRules.haveSameType(path.getVerticesAsSet(), connectingVertex);
        OrionList<Edge> edges = path.getEdgesCopy();
        GraphType type = path.getType();

        if(type.is(GraphType.Number))
        {
            edges.add(NumberEdge.of((NumberVertex)path.getLastVertex(), (NumberVertex)connectingVertex));
            edges.add(NumberEdge.of((NumberVertex)connectingVertex, (NumberVertex)other.getFirstVertex()));
        }
        else if(type.is(GraphType.Point))
        {
            edges.add(PointEdge.of((PointVertex)path.getLastVertex(), (PointVertex)connectingVertex));
            edges.add(PointEdge.of((PointVertex)connectingVertex, (PointVertex)other.getFirstVertex()));
        }
        else if(type.is(GraphType.Object))
        {
            edges.add(ObjectEdge.of((ObjectVertex)path.getLastVertex(), (ObjectVertex)connectingVertex));
            edges.add(ObjectEdge.of((ObjectVertex)connectingVertex, (ObjectVertex)other.getFirstVertex()));
        }

        edges.addAll(other.getEdgesCopy());
        return Path.of(edges);
    }
}