package com.orion.math.graph.tasks.distance;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.EdgeService;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GetShortestPathBetween2VerticesOnWeightedGraphTask extends Orion
{
    private Map<Vertex, ANumber> vertex1ToOtherVertexToDistanceMapper;
    private Vertex v2;


    public Path run(Graph graph, Vertex v1, Vertex v2)
    {
        GraphRules.isSimple(graph);
        GraphRules.isWeighted(graph);
        GraphRules.isConnected(graph);
        GraphRules.doEdgesHavePositiveWeights(graph);
        GraphRules.areVerticesInGraph(graph, v1, v2);
        this.v2 = v2;
        OrionList<Edge> edges = OrionArrayList.of();
        Map<Vertex, ANumber> vertex1ToOtherVertexToDistanceMapper = new HashMap<>();
        Set<Vertex> verticesOfShortestPath = new HashSet<>();
        graph.getVertices().filter(vertex -> vertex.notEquals(v1)).forEach(vertex -> vertex1ToOtherVertexToDistanceMapper.put(vertex, ANumber.ofMax()));

        while(!verticesOfShortestPath.contains(v2))
        {
            ANumber minimumDistance = ArithmeticService.getMinimum(new ArrayList<ANumber>(vertex1ToOtherVertexToDistanceMapper.values()));
            vertex1ToOtherVertexToDistanceMapper.entrySet().stream().anyMatch(entry -> entry.getValue().equal(minimumDistance));
            Vertex vertexJustAddedToSet = null;

            for(Map.Entry<Vertex, ANumber> entry : vertex1ToOtherVertexToDistanceMapper.entrySet())
            {

                if(entry.getValue().equal(minimumDistance))
                {
                    verticesOfShortestPath.add(entry.getKey());
                    vertexJustAddedToSet = entry.getKey();
                    break;
                }

            }

            final Vertex vertexJustAddedToSetCopy = vertexJustAddedToSet.getCopy();

            for(Vertex vertex : graph.getVertices())
            {

                if(!verticesOfShortestPath.contains(vertex) && vertex.notEquals(v1))
                {
                    ANumber distanceBetweenV1AndVertex = vertex1ToOtherVertexToDistanceMapper.get(vertex);
                    ANumber distanceBetweenV1AndVertexJustAddedToSet = vertex1ToOtherVertexToDistanceMapper.get(vertexJustAddedToSet);
                    ANumber newDistance = ArithmeticService.getMinimum(distanceBetweenV1AndVertex, distanceBetweenV1AndVertexJustAddedToSet);
                    List<Edge> edgesIncidentAtVertexJustAddedToSetAndVertex = graph.getEdges().filter(edge -> edge.isIncidentAt(vertexJustAddedToSetCopy, vertex)).collect(Collectors.toList());

                    if(!edgesIncidentAtVertexJustAddedToSetAndVertex.isEmpty())
                    {
                        List<ANumber> weights = edgesIncidentAtVertexJustAddedToSetAndVertex.stream().map(edge -> edge.getWeight()).collect(Collectors.toList());
                        ANumber minimumWeight = ArithmeticService.getMinimum(weights);
                        newDistance = newDistance.addGET(minimumWeight);
                    }

                    vertex1ToOtherVertexToDistanceMapper.put(vertex, newDistance);
                }

            }

        }

        this.vertex1ToOtherVertexToDistanceMapper = vertex1ToOtherVertexToDistanceMapper;
        List<Vertex> verticesOfShortestPathTemp = new ArrayList<>(verticesOfShortestPath);
        edges.add(EdgeService.createEdgeBetween(graph.getType(), v1, verticesOfShortestPathTemp.get(0)));

        for(int i = 1; i < verticesOfShortestPathTemp.size() - 1; i++)
        {
            edges.add(EdgeService.createEdgeBetween(graph.getType(), verticesOfShortestPathTemp.get(i), verticesOfShortestPathTemp.get(i + 1)));
        }

        return Path.of(edges);
    }


    public ANumber getLengthOfPath()
    {
        return vertex1ToOtherVertexToDistanceMapper.get(v2);
    }
}