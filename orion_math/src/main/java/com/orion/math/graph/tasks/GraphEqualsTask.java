package com.orion.math.graph.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.edge.Edge;
import com.orion.math.streams.NumberArrayStream;
import java.util.List;

public class GraphEqualsTask extends Orion
{
    public static boolean run(Graph x, Object y)
    {
        GraphRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Graph other = (Graph)y;
            List<Edge> edgesOfX = x.getEdges().getAsList();
            List<Edge> edgesOfY = other.getEdges().getAsList();
            int[] indicesOfXThatHaveAnEqual = new int[edgesOfX.size()];
            NumberArrayStream.setValue(indicesOfXThatHaveAnEqual, -1);
            int[] indicesOfYThatHaveAnEqual = new int[edgesOfY.size()];
            NumberArrayStream.setValue(indicesOfYThatHaveAnEqual, -1);
            boolean verticesAreEqual = x.getVertices().equals(other.getVertices());
            boolean edgesAreEqual = edgesOfX.size() == edgesOfY.size();

            if(!edgesAreEqual)
            {
                return false;
            }

            for(int i = 0; i < edgesOfX.size(); i++)
            {
                boolean found = false;

                for(int j = 0; j < edgesOfY.size(); j++)
                {

                    if((edgesOfX.get(i).getFirst().equals(edgesOfY.get(j).getFirst())
                                    && edgesOfX.get(i).getSecond().equals(edgesOfY.get(j).getSecond()))
                                    || ((edgesOfX.get(i).getFirst().equals(edgesOfY.get(j).getSecond())
                                                    && edgesOfX.get(i).getSecond().equals(edgesOfY.get(j).getFirst()))))
                    {
                        found = true;
                        indicesOfXThatHaveAnEqual[i] = i;
                        indicesOfYThatHaveAnEqual[j] = j;
                        break;
                    }

                }

                if(!found)
                {
                    edgesAreEqual = false;
                }

            }

            for(int i = 0; i < indicesOfXThatHaveAnEqual.length; i++)
            {

                if(indicesOfXThatHaveAnEqual[i] == -1 || indicesOfYThatHaveAnEqual[i] == -1)
                {
                    return false;
                }
                else if(indicesOfXThatHaveAnEqual[i] != indicesOfYThatHaveAnEqual[i])
                {
                    return false;
                }
                else if(indicesOfXThatHaveAnEqual[i] != i || indicesOfYThatHaveAnEqual[i] != i)
                {
                    return false;
                }

            }

            return verticesAreEqual && edgesAreEqual;
        }

    }
}