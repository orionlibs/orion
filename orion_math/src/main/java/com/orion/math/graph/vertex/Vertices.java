package com.orion.math.graph.vertex;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.MathRule;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.graph.vertex.point.PointVertex;

public class Vertices extends MathRule
{
    public static GraphType getType(Vertex vertex)
    {
        VertexRules.isValid(vertex);

        if(vertex instanceof NumberVertex)
        {
            return GraphType.Number;
        }
        else if(vertex instanceof PointVertex)
        {
            return GraphType.Point;
        }
        else
        {
            return GraphType.Object;
        }

    }


    public static GraphType getType(OrionSet<Vertex> vertices)
    {
        VertexRules.areValid(vertices);
        GraphType graphType = getType(vertices.getRandomElement());

        for(Vertex vertex : vertices)
        {

            if(getType(vertex).isNot(graphType))
            {
                return GraphType.Either;
            }

        }

        return graphType;
    }
}