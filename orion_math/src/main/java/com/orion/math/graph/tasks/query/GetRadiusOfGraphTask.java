package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.util.List;
import java.util.stream.Collectors;

public class GetRadiusOfGraphTask extends Orion
{
    public static ANumber run(Graph graph)
    {
        GraphRules.isValid(graph);
        List<ANumber> eccentricities = graph.getVerticesAsList()
                        .stream()
                        .map(v -> graph.getEccentricityOfVertex(v)).collect(Collectors.toList());
        return ArithmeticService.getMinimum(eccentricities);
    }
}