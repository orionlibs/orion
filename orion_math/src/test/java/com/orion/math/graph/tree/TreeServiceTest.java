package com.orion.math.graph.tree;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.edge.number.NumberEdge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.number.NumberVertex;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class TreeServiceTest
{
    @Test
    public void getLeaves()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberVertex v4 = NumberVertex.of(4);
        NumberVertex v5 = NumberVertex.of(5);
        NumberVertex v6 = NumberVertex.of(6);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        NumberEdge e2 = NumberEdge.of(v1, v3);
        NumberEdge e3 = NumberEdge.of(v2, v4);
        NumberEdge e4 = NumberEdge.of(v2, v5);
        NumberEdge e5 = NumberEdge.of(v3, v6);
        Tree t1 = Tree.of(new OrionHashSet<>(v1, v2, v3, v4, v5, v6), new OrionHashSet<>(e1, e2, e3, e4, e5), v1);
        Vertex[] result = TreeService.getLeaves(t1);
        assertTrue(result.length == 3);
        assertTrue(result[0].equals(v4));
        assertTrue(result[1].equals(v5));
        assertTrue(result[2].equals(v6));
    }


    @Test
    public void getRoot1()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberVertex v4 = NumberVertex.of(4);
        NumberVertex v5 = NumberVertex.of(5);
        NumberVertex v6 = NumberVertex.of(6);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        NumberEdge e2 = NumberEdge.of(v1, v3);
        NumberEdge e3 = NumberEdge.of(v2, v4);
        NumberEdge e4 = NumberEdge.of(v2, v5);
        NumberEdge e5 = NumberEdge.of(v3, v6);
        Tree t1 = Tree.of(new OrionHashSet<>(v1, v2, v3, v4, v5, v6), new OrionHashSet<>(e1, e2, e3, e4, e5), v1);
        Vertex result = TreeService.getRoot(t1);
        assertTrue(result.getVertexPoint().equals(v1.getVertexPoint()));
    }


    @Test
    public void getRoot2()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberVertex v4 = NumberVertex.of(4);
        NumberVertex v5 = NumberVertex.of(5);
        NumberVertex v6 = NumberVertex.of(6);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        NumberEdge e2 = NumberEdge.of(v1, v3);
        NumberEdge e3 = NumberEdge.of(v2, v4);
        NumberEdge e4 = NumberEdge.of(v2, v5);
        NumberEdge e5 = NumberEdge.of(v3, v6);
        Tree t1 = Tree.of(new OrionHashSet<>(v1, v2, v3, v4, v5, v6), new OrionHashSet<>(e1, e2, e3, e4, e5));
        Vertex result = TreeService.getRoot(t1);
        assertTrue(result.getVertexPoint().equals(v1.getVertexPoint()));
    }
}