package com.orion.math.graph.tasks.degree;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;

public class GetOutdegreesOfVerticesTask extends Orion
{
    public static ANumber[] run(Graph graph)
    {
        GraphRules.isValid(graph);
        List<ANumber> degrees = new ArrayList<ANumber>(graph.getNumberOfVertices());
        graph.getVertices().forAll(v -> degrees.add(graph.getOutdegreeOf(v)));
        return degrees.toArray(new ANumber[0]);
    }
}