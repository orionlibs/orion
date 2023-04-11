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

public class IsDigraphLEdgeConnectedTask extends Orion
{
    public static boolean run(Digraph digraph, ANumber l)
    {
        DigraphRules.isValid(digraph);
        NumberRules.hasNaturalNumberValue(l);

        if(digraph.getOrder().isGreaterThan(1))
        {
            Stream<Digraph> subgraphsWithLessThanLEdges = digraph.getAllPossibleSubgraphsOfDigraphAsList().filter(g -> g.getNumberOfEdgesAsNumber().isLessThan(l));
            OrionList<Digraph> subgraphs = OrionArrayList.of(OrionStream.getAsList(subgraphsWithLessThanLEdges));
            return !subgraphs.findAny(subgraph -> digraph.subtractEdges(subgraph.getEdges()).isNotConnected());
        }
        else
        {
            return false;
        }

    }
}