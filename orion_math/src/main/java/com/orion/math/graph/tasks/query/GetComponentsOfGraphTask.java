package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.combinatorics.CombinatoricsService;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import java.util.List;

public class GetComponentsOfGraphTask extends Orion
{
    public static Graph[] run(Graph graph)
    {
        GraphRules.isValid(graph);
        OrionList<Graph> components = OrionArrayList.of();

        for(int i = 1; i <= graph.getNumberOfVertices(); i++)
        {
            List<List<Vertex>> vertexCombinations = CombinatoricsService.getCombinationsWithoutElementRepetition(graph.getVerticesAsList(), i);

            for(List<Vertex> combination : vertexCombinations)
            {
                OrionSet<Vertex> vertices = OrionHashSet.<Vertex>of(combination);
                OrionSet<Edge> edges = OrionHashSet.<Edge>of();
                vertices.forAll(v -> edges.addAll(graph.getEdgesThatIncludeVertexAsList(v)));
                Graph subgraph = Graph.of(vertices, edges);
                components.appendIf(subgraph, (Graph g) -> graph.isComponent(g));
            }

        }

        return components.toArray(new Graph[0]);
    }
}