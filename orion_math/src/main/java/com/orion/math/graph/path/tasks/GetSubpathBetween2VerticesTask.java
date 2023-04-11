package com.orion.math.graph.path.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.number.NumberEdge;
import com.orion.math.graph.edge.object.ObjectEdge;
import com.orion.math.graph.edge.point.PointEdge;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.path.PathRules;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.Vertices;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.graph.vertex.object.ObjectVertex;
import com.orion.math.graph.vertex.point.PointVertex;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GetSubpathBetween2VerticesTask extends Orion
{
    public static Path run(Path path, Vertex fromVertex, Vertex toVertex)
    {
        PathRules.isValid(path);
        PathRules.doVerticesBelongToPath(path, fromVertex, toVertex);
        OrionSet<Vertex> vertices2 = OrionHashSet.<Vertex>of();
        vertices2.add(fromVertex);
        vertices2.add(toVertex);
        OrionList<Edge> edges = OrionArrayList.of();
        List<Vertex> vertices = new ArrayList<Vertex>();
        int indexOfFromVertex = path.getIndexOfVertex(fromVertex);
        int indexOfToVertex = path.getIndexOfVertex(toVertex);
        GraphType type = Vertices.getType(fromVertex);
        IntStream.range(indexOfFromVertex, indexOfToVertex + 1)
                        .forEach(i -> vertices.add(path.getVertex(i).getCopy()));

        for(int i = 0; i < vertices.size() - 1; i++)
        {

            if(type.is(GraphType.Number))
            {
                edges.add(NumberEdge.of((NumberVertex)vertices.get(i), (NumberVertex)vertices.get(i + 1)));
            }
            else if(type.is(GraphType.Point))
            {
                edges.add(PointEdge.of((PointVertex)vertices.get(i), (PointVertex)vertices.get(i + 1)));
            }
            else if(type.is(GraphType.Object))
            {
                edges.add(ObjectEdge.of((ObjectVertex)vertices.get(i), (ObjectVertex)vertices.get(i + 1)));
            }

        }

        return Path.of(edges);
    }
}