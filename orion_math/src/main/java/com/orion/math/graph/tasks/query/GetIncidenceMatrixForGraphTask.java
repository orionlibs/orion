package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;

public class GetIncidenceMatrixForGraphTask extends Orion
{
    public static Matrix run(Graph graph)
    {
        GraphRules.isValid(graph);
        ANumber[][] elements = new ANumber[graph.getNumberOfVertices()][graph.getNumberOfEdges()];
        Vertex[] vertices = graph.getVerticesAsArray();
        Edge[] edges = graph.getEdgesAsArray();

        for(int i = 0; i < graph.getNumberOfVertices(); i++)
        {

            for(int j = 0; j < graph.getNumberOfEdges(); j++)
            {

                if(edges[j].isIncidentAt(vertices[i]))
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