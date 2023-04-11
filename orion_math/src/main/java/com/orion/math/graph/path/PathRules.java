package com.orion.math.graph.path;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.math.MathRule;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeRules;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;
import java.util.Arrays;

public class PathRules extends MathRule
{
    public static void isValid(OrionList<Edge> edges)
    {
        EdgeRules.haveSameType(edges);
    }


    public static void doVerticesBelongToPath(Path path, Vertex fromVertex, Vertex toVertex)
    {
        isValid(path);
        VertexRules.areValid(fromVertex, toVertex);
        Vertex[] vertices = path.getVertices();
        int indexOfFromVertex = -1;
        int indexOfToVertex = -1;

        for(int i = 0; i < vertices.length; i++)
        {

            if(vertices[i].equals(fromVertex))
            {
                indexOfFromVertex = i;
            }

            if(vertices[i].equals(toVertex))
            {
                indexOfToVertex = i;
            }

        }

        Assert.areNotEqual(indexOfFromVertex, -1, "Vertices do not belong to path.");
        Assert.areNotEqual(indexOfToVertex, -1, "Vertices do not belong to path.");
        Assert.isLessThanOrEqualTo(indexOfFromVertex, indexOfToVertex, "FromVertex is after ToVertex. It should be before.");
    }


    public static void doPathVerticesBelongToGraph(Path path, Graph graph)
    {
        isValid(path);
        GraphRules.isValid(graph);
        Vertex[] vertices = path.getVertices();

        for(int i = 0; i < vertices.length; i++)
        {

            if(graph.notContainsVertex(vertices[i]))
            {
                throw new InvalidArgumentException("At least one vertex of the path does not belong to the graph.");
            }

        }

    }


    public static void isValid(Path path)
    {
        Assert.notNull(path, "the path input cannot be null.");
        isValid(path.getEdges());
    }


    public static void areValid(Path... paths)
    {
        Assert.notEmpty(paths, "the paths input cannot be null/empty.");
        Arrays.stream(paths).forEach(path -> isValid(path));
    }


    public static void doPathsHaveSameType(Path... paths)
    {
        Assert.notEmpty(paths, "the paths input cannot be null/empty.");
        GraphType type = paths[0].getType();

        for(int i = 1; i < paths.length; i++)
        {
            Assert.isFalse(type.isNot(paths[i].getType()), "Paths types do not matc.");
        }

    }
}