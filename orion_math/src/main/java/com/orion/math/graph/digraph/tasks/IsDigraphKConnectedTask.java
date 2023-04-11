package com.orion.math.graph.digraph.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.stream.OrionStream;
import com.orion.math.graph.digraph.Digraph;
import com.orion.math.graph.digraph.DigraphRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.stream.Stream;

public class IsDigraphKConnectedTask extends Orion
{
    public static boolean run(Digraph digraph, ANumber k)
    {
        DigraphRules.isValid(digraph);
        NumberRules.hasNaturalNumberValue(k);

        if(digraph.getOrder().isGreaterThan(k))
        {
            Stream<Digraph> subgraphsWithOrderLessThanK = digraph.getAllPossibleSubgraphsOfDigraphAsList().filter(g -> g.getOrder().isLessThan(k));
            OrionList<Digraph> subgraphs = OrionArrayList.of(OrionStream.getAsList(subgraphsWithOrderLessThanK));
            return !subgraphs.findAny(subgraph -> digraph.subtract(subgraph.getVertices()).isNotConnected());
        }
        else
        {
            return false;
        }

    }
}