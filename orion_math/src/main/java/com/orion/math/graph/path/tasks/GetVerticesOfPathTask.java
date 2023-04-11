package com.orion.math.graph.path.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.path.PathRules;
import com.orion.math.graph.vertex.Vertex;
import java.util.stream.IntStream;

public class GetVerticesOfPathTask extends Orion
{
    public static Vertex[] run(Path path)
    {
        PathRules.isValid(path);
        Vertex[] vertices = new Vertex[path.getEdges().getSize()];
        vertices[0] = path.getFirstVertex();
        vertices[path.getEdges().getSize() - 1] = path.getLastVertex();
        IntStream.range(1, path.getEdges().getSize() - 1)
                        .forEach(i -> vertices[i] = path.getEdge(i).getFirst());
        return vertices;
    }
}