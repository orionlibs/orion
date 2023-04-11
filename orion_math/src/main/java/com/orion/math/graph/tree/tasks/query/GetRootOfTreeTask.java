package com.orion.math.graph.tree.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.tree.Tree;
import com.orion.math.graph.tree.TreeHasMultipleRootsException;
import com.orion.math.graph.tree.TreeRules;
import com.orion.math.graph.vertex.Vertex;

public class GetRootOfTreeTask extends Orion
{
    public static Vertex run(Tree tree) throws TreeHasMultipleRootsException
    {
        TreeRules.isValid(tree);

        if(tree.getRoot() != null)
        {
            return tree.getRoot();
        }
        else if(tree.getNumberOfVertices() == 1)
        {
            return tree.getVerticesAsArray()[0];
        }
        else
        {
            return run(tree.getVertices(), tree.getEdges());
        }

    }


    public static Vertex run(OrionSet<Vertex> vertices, OrionSet<Edge> edges) throws TreeHasMultipleRootsException
    {
        TreeRules.isValid(vertices, edges);
        Vertex root = null;

        for(Vertex vertex : vertices)
        {

            if(edges.findNone(edge -> edge.getSecond().equals(vertex)))
            {

                if(root != null)
                {
                    throw new TreeHasMultipleRootsException("Tree has multiple roots. It can only have 1.");
                }
                else
                {
                    root = vertex;
                }

            }

        }

        if(root != null)
        {
            return root;
        }
        else
        {
            throw new TreeHasMultipleRootsException("Tree has no root. It has to have 1 root.");
        }

    }
}