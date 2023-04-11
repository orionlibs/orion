package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.stream.OrionStream;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;
import java.util.ArrayList;
import java.util.List;

public class GetCutverticesOfGraphTask extends Orion
{
    public static Vertex[] run(Graph graph)
    {
        GraphRules.isValid(graph);
        List<Vertex> cutvertices = new ArrayList<Vertex>();

        for(Graph component : graph.getComponents())
        {
            OrionSet<Vertex> vertices = component.getVerticesCopy();
            cutvertices.addAll(OrionStream.getAsList(vertices.filter(v -> graph.isCutvertex(component, v))));
        }

        return cutvertices.toArray(new Vertex[0]);
    }
}