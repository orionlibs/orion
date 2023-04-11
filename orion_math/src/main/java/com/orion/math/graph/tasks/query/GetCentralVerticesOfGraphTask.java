package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;

public class GetCentralVerticesOfGraphTask extends Orion
{
    public static Vertex[] run(Graph graph)
    {
        GraphRules.isValid(graph);
        ANumber minimumEccentricity = ANumber.ofMax();
        List<Vertex> verticesWithMinimumEccentricity = new ArrayList<Vertex>();
        OrionList<Vertex> vertices = graph.getVerticesAsList();

        for(int i = 0; i < vertices.getSize(); i++)
        {
            ANumber eccentricity = graph.getEccentricityOfVertex(vertices.get(i));

            if(eccentricity.isLessThan(minimumEccentricity))
            {
                minimumEccentricity = eccentricity;
                verticesWithMinimumEccentricity.clear();
                verticesWithMinimumEccentricity.add(vertices.get(i));
            }
            else if(eccentricity.equal(minimumEccentricity))
            {
                verticesWithMinimumEccentricity.add(vertices.get(i));
            }

        }

        return verticesWithMinimumEccentricity.toArray(new Vertex[0]);
    }
}