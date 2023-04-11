package com.orion.math.graph.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.GraphType;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeService;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;

public class BuildEdgesFromAdjacencyMatrixForGraphTask extends Orion
{
    public static OrionSet<Edge> run(GraphType graphType, OrionSet<Vertex> vertices, Matrix adjacencyMatrix)
    {
        OrionSet<Edge> newEdges = OrionHashSet.of();
        ANumber[][] adjacencies = adjacencyMatrix.getAsArrayOfArrays();
        Vertex[] verticesTemp = vertices.getAsList().toArray(new Vertex[0]);

        for(int i = 0; i < adjacencies.length; i++)
        {

            for(int j = 0; j < adjacencies[0].length; j++)
            {

                if(adjacencies[i][j].isOne())
                {
                    newEdges.add(EdgeService.createEdgeBetween(graphType, verticesTemp[i], verticesTemp[j]));
                }

            }

        }

        return newEdges;
    }
}