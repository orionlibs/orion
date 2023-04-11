package com.orion.math.graph.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.streams.NumberStream;

public class GetEdgeConnectivityOfGraphTask extends Orion
{
    public static ANumber run(Graph graph)
    {
        GraphRules.isValid(graph);

        if(graph.isNotConnected())
        {
            return ANumber.of(0);
        }
        else
        {
            NumberStream stream = NumberStream.of(1, graph.getNumberOfEdgesAsNumber().subtractOneGET());
            return ArithmeticService.getMaximum(stream.filter(l -> graph.isLEdgeConnected(l)).getAsList());
        }

    }
}