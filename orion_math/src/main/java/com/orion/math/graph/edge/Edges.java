package com.orion.math.graph.edge;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.MathRule;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.number.NumberEdge;
import com.orion.math.graph.edge.object.ObjectEdge;
import com.orion.math.graph.edge.point.PointEdge;

public class Edges extends MathRule
{
    public static GraphType getType(Edge edge)
    {
        EdgeRules.isValid(edge);

        if(edge instanceof NumberEdge)
        {
            return GraphType.Number;
        }
        else if(edge instanceof PointEdge)
        {
            return GraphType.Point;
        }
        else if(edge instanceof ObjectEdge)
        {
            return GraphType.Object;
        }
        else
        {
            return GraphType.Either;
        }

    }


    public static GraphType getType(OrionSet<Edge> edges)
    {
        EdgeRules.areValid(edges);
        GraphType edgeType = getType(edges.getRandomElement());

        for(Edge edge : edges)
        {

            if(getType(edge).isNot(edgeType))
            {
                return GraphType.Either;
            }

        }

        return edgeType;
    }


    public static GraphType getType(OrionList<Edge> edges)
    {
        EdgeRules.areValid(edges);
        GraphType edgeType = getType(edges.getFirst());

        for(Edge edge : edges)
        {

            if(getType(edge).isNot(edgeType))
            {
                return GraphType.Either;
            }

        }

        return edgeType;
    }
}