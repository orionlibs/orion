package com.orion.math.graph.digraph.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.combinatorics.CombinatoricsService;
import com.orion.math.graph.digraph.Digraph;
import com.orion.math.graph.digraph.DigraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeService;
import com.orion.math.graph.vertex.Vertex;
import java.util.List;

public class GetAllPossibleSubgraphsOfDigraphTask extends Orion
{
    public static Digraph[] run(Digraph digraph)
    {
        DigraphRules.isValid(digraph);
        OrionList<Digraph> subgraphs = OrionArrayList.of();

        for(int i = 1; i <= digraph.getNumberOfVertices(); i++)
        {
            List<List<Vertex>> vertexCombinations = CombinatoricsService.getCombinationsWithoutElementRepetition(digraph.getVerticesAsList(), i);

            for(List<Vertex> combination : vertexCombinations)
            {
                OrionSet<Vertex> vertices = OrionHashSet.<Vertex>of(combination);
                OrionSet<Edge> edges = EdgeService.getAllPossibleDirectedEdges(vertices);
                subgraphs.add(Digraph.of(vertices, edges));
            }

        }

        return subgraphs.toArray(new Digraph[0]);
    }
}