package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.VertexRules;
import java.util.ArrayList;
import java.util.List;

public class GetPathsBetween2VerticesOfGraphTask extends Orion
{
    private Vertex toVertex;
    private List<Path> paths = null;
    private boolean stopCurrentProcess;


    public Path[] run(Graph graph, Vertex v1, Vertex v2)
    {
        GraphRules.isValid(graph);
        VertexRules.areValid(v1, v2);
        this.toVertex = v2;
        this.paths = new ArrayList<Path>();

        if(graph.containsVertex(v1) && graph.containsVertex(v2))
        {
            Edge[] edgesThatIncludeVertex1AsFirst = graph.getEdgesThatIncludeVertexAsFirst(v1);

            for(int i = 0; i < edgesThatIncludeVertex1AsFirst.length; i++)
            {
                stopCurrentProcess = false;
                processEdges(graph, edgesThatIncludeVertex1AsFirst[i], OrionArrayList.<Edge>of());
            }

        }

        return paths.toArray(new Path[0]);
    }


    private void processEdges(Graph graph, Edge edgeThatHasVertexAsFirstVertex, OrionList<Edge> edges)
    {

        if(edges.notContains(edgeThatHasVertexAsFirstVertex))
        {
            edges.add(edgeThatHasVertexAsFirstVertex);

            if(edgeThatHasVertexAsFirstVertex.getSecond().equals(toVertex))
            {
                paths.add(Path.of(edges.getCopy()));
            }
            else
            {
                Edge[] edgesThatIncludeVertex2AsFirst = graph.getEdgesThatIncludeVertexAsFirst(edgeThatHasVertexAsFirstVertex.getSecond());

                if(edgesThatIncludeVertex2AsFirst.length == 0)
                {
                    edges.clear();
                    return;
                }
                else
                {

                    for(int i = 0; i < edgesThatIncludeVertex2AsFirst.length; i++)
                    {

                        if(edgesThatIncludeVertex2AsFirst[i].getSecond().equals(toVertex))
                        {
                            edges.add(edgesThatIncludeVertex2AsFirst[i]);
                            paths.add(Path.of(edges.getCopy()));
                            break;
                        }
                        else
                        {

                            if(stopCurrentProcess)
                            {
                                return;
                            }
                            else
                            {
                                processEdges(graph, edgesThatIncludeVertex2AsFirst[i], edges);
                            }

                        }

                    }

                }

            }

        }
        else
        {

            if(edgeThatHasVertexAsFirstVertex.getSecond().equals(toVertex))
            {
                paths.add(Path.of(edges.getCopy()));
            }

            edges.clear();
            stopCurrentProcess = true;
            return;
        }

    }
}