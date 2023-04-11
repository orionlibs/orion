package com.orion.math.graph.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.combinatorics.permutations.PermutationService;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AreGraphsIsomorphicTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static boolean run(Graph graph, Graph other)
    {
        GraphRules.doGraphsHaveSameNumberOfVertices(graph, other);
        Matrix adjacencyMatrixOfGraph = graph.getAdjacencyMatrix();
        Matrix adjacencyMatrixOfOther = other.getAdjacencyMatrix();

        if(adjacencyMatrixOfGraph.equals(adjacencyMatrixOfOther))
        {
            return true;
        }
        else
        {
            List<Integer> objectsToPermute = new ArrayList<>();
            IntStream.range(0, adjacencyMatrixOfGraph.getNumberOfRows()).forEach(i -> objectsToPermute.add(i));
            List<List<?>> permutationsOfrows = PermutationService.permute(objectsToPermute);

            for(List<?> permutationOfRows : permutationsOfrows)
            {
                List<Integer> permutations = (List<Integer>)permutationOfRows;
                ANumber[][] newElements = new ANumber[permutations.size()][permutations.size()];

                for(int i = 0; i < permutations.size(); i++)
                {

                    for(int j = 0; j < permutations.size(); j++)
                    {
                        newElements[i][j] = adjacencyMatrixOfGraph.get(permutations.indexOf(i), permutations.indexOf(j));
                    }

                }

                if(Matrix.of(newElements).equals(adjacencyMatrixOfOther))
                {
                    return true;
                }

            }

        }

        return false;
    }
}