package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;

public class GetAdjacencyMatrixForGraphTask extends Orion
{
    public static Matrix run(Graph graph)
    {
        GraphRules.isValid(graph);
        ANumber[][] elements = new ANumber[graph.getNumberOfVertices()][graph.getNumberOfVertices()];
        Vertex[] vertices = graph.getVerticesAsArray();

        for(int i = 0; i < graph.getNumberOfVertices(); i++)
        {

            for(int j = 0; j < graph.getNumberOfVertices(); j++)
            {

                if(graph.areVerticesAdjacent(vertices[i], vertices[j]))
                {
                    elements[i][j] = ANumber.of(1);
                }
                else
                {
                    elements[i][j] = ANumber.of(0);
                }

            }

        }

        return Matrix.of(elements);
    }
}