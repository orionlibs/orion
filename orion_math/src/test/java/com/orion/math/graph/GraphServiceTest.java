package com.orion.math.graph;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.edge.number.NumberEdge;
import com.orion.math.graph.path.Path;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.graph.vertex.number.NumberVertex;
import com.orion.math.graph.vertex.object.ObjectVertex;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class GraphServiceTest
{
    @Test
    public void getOrder1()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(3);
        Graph g = Graph.of(new OrionHashSet<>(v1, v2));
        ANumber result = GraphService.getOrder(g);
        assertTrue(ANumber.of(2).equal(result));
    }


    @Test
    public void getOrder2()
    {
        ObjectVertex v1 = ObjectVertex.of(1);
        ObjectVertex v2 = ObjectVertex.of(3);
        Graph g = Graph.of(new OrionHashSet<>(v1, v2));
        ANumber result = GraphService.getOrder(g);
        assertTrue(ANumber.of(2).equal(result));
    }


    @Test
    public void areAdjacent()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(3);
        NumberVertex v3 = NumberVertex.of(6);
        NumberVertex v4 = NumberVertex.of(8);
        NumberEdge e1 = NumberEdge.of(v1, v3);
        Graph g = Graph.of(new OrionHashSet<>(v1, v2, v3, v4), new OrionHashSet<>(e1));
        boolean result = GraphService.areAdjacent(g, v1, v2);
        assertFalse(result);
        result = GraphService.areAdjacent(g, v1, v3);
        assertTrue(result);
    }


    @Test
    public void isComplete()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(3);
        NumberVertex v3 = NumberVertex.of(6);
        NumberEdge e1 = NumberEdge.of(v1, v3);
        Graph g = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1));
        boolean result = GraphService.isComplete(g);
        assertFalse(result);
        NumberEdge e2 = NumberEdge.of(v1, v2);
        NumberEdge e3 = NumberEdge.of(v2, v3);
        g = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1, e2, e3));
        result = GraphService.isComplete(g);
        assertTrue(result);
    }


    @Test
    public void getUnion()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1));
        NumberVertex v4 = NumberVertex.of(4);
        NumberVertex v5 = NumberVertex.of(5);
        NumberVertex v6 = NumberVertex.of(6);
        NumberEdge e2 = NumberEdge.of(v4, v6);
        Graph g2 = Graph.of(new OrionHashSet<>(v4, v5, v6), new OrionHashSet<>(e2));
        Graph result = GraphService.getUnion(g1, g2);
        OrionSet<Vertex> expectedVertices = OrionHashSet.<Vertex>of(v1, v2, v3, v4, v5, v6);
        OrionSet<Edge> expectedEdges = OrionHashSet.<Edge>of(e1, e2);
        assertTrue(expectedVertices.equals(result.getVertices()));
        assertTrue(expectedEdges.equals(result.getEdges()));
    }


    @Test
    public void getIntersection1()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1));
        NumberVertex v4 = NumberVertex.of(2);
        NumberVertex v5 = NumberVertex.of(5);
        NumberVertex v6 = NumberVertex.of(6);
        NumberEdge e2 = NumberEdge.of(v4, v6);
        Graph g2 = Graph.of(new OrionHashSet<>(v4, v5, v6), new OrionHashSet<>(e2));
        Graph result = GraphService.getIntersection(g1, g2);
        OrionSet<Vertex> expectedVertices = OrionHashSet.<Vertex>of(v2);
        OrionSet<Edge> expectedEdges = OrionHashSet.<Edge>of();
        assertTrue(expectedVertices.equals(result.getVertices()));
        assertTrue(expectedEdges.equals(result.getEdges()));
    }


    @Test
    public void getIntersection2()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1));
        NumberVertex v4 = NumberVertex.of(2);
        NumberVertex v5 = NumberVertex.of(5);
        NumberVertex v6 = NumberVertex.of(1);
        NumberEdge e2 = NumberEdge.of(v6, v4);
        Graph g2 = Graph.of(new OrionHashSet<>(v4, v5, v6), new OrionHashSet<>(e2));
        Graph result = GraphService.getIntersection(g1, g2);
        OrionSet<Vertex> expectedVertices = OrionHashSet.<Vertex>of(v1, v2);
        OrionSet<Edge> expectedEdges = OrionHashSet.<Edge>of(e1);
        assertTrue(expectedVertices.equals(result.getVertices()));
        assertTrue(expectedEdges.equals(result.getEdges()));
    }


    @Test
    public void getIntersection3()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1));
        NumberVertex v4 = NumberVertex.of(2);
        NumberVertex v5 = NumberVertex.of(5);
        NumberVertex v6 = NumberVertex.of(1);
        NumberEdge e2 = NumberEdge.of(v4, v5);
        Graph g2 = Graph.of(new OrionHashSet<>(v4, v5, v6), new OrionHashSet<>(e2));
        Graph result = GraphService.getIntersection(g1, g2);
        OrionSet<Vertex> expectedVertices = OrionHashSet.<Vertex>of(v1, v2);
        OrionSet<Edge> expectedEdges = OrionHashSet.<Edge>of();
        assertTrue(expectedVertices.equals(result.getVertices()));
        assertTrue(expectedEdges.equals(result.getEdges()));
    }


    @Test
    public void isSubgraphOf1()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1));
        NumberVertex v4 = NumberVertex.of(2);
        NumberVertex v5 = NumberVertex.of(1);
        NumberEdge e2 = NumberEdge.of(v5, v4);
        Graph g2 = Graph.of(new OrionHashSet<>(v4, v5), new OrionHashSet<>(e2));
        boolean result = GraphService.isSubgraphOf(g2, g1);
        assertTrue(result);
        result = GraphService.isSubgraphOf(g1, g2);
        assertFalse(result);
        e2 = NumberEdge.of(v4, v5);
        g2 = Graph.of(new OrionHashSet<>(v4, v5), new OrionHashSet<>(e2));
        result = GraphService.isSubgraphOf(g2, g1);
        assertFalse(result);
    }


    @Test
    public void isSubgraphOf2()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1));
        NumberVertex v4 = NumberVertex.of(2);
        NumberVertex v5 = NumberVertex.of(5);
        NumberEdge e2 = NumberEdge.of(v4, v5);
        Graph g2 = Graph.of(new OrionHashSet<>(v4, v5), new OrionHashSet<>(e2));
        boolean result = GraphService.isSubgraphOf(g2, g1);
        assertFalse(result);
    }


    @Test
    public void subtract()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1));
        Graph result = GraphService.subtract(g1, v2);
        OrionSet<Vertex> expectedVertices = OrionHashSet.<Vertex>of(v1, v3);
        OrionSet<Edge> expectedEdges = OrionHashSet.<Edge>of();
        assertTrue(expectedVertices.equals(result.getVertices()));
        assertTrue(expectedEdges.equals(result.getEdges()));
    }


    @Test
    public void subtractEdge()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1));
        Graph result = GraphService.subtractEdge(g1, e1);
        OrionSet<Vertex> expectedVertices = OrionHashSet.<Vertex>of(v1, v2, v3);
        OrionSet<Edge> expectedEdges = OrionHashSet.<Edge>of();
        assertTrue(expectedVertices.equals(result.getVertices()));
        assertTrue(expectedEdges.equals(result.getEdges()));
    }


    @Test
    public void getComplement()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1));
        Graph result = GraphService.getComplement(g1);
        OrionSet<Vertex> expectedVertices = OrionHashSet.<Vertex>of(v1, v2, v3);
        NumberEdge e2 = NumberEdge.of(v1, v3);
        NumberEdge e3 = NumberEdge.of(v2, v3);
        OrionSet<Edge> expectedEdges = OrionHashSet.<Edge>of(e2, e3);
        assertTrue(expectedVertices.equals(result.getVertices()));
        assertTrue(expectedEdges.equals(result.getEdges()));
    }


    @Test
    public void joinVerticesToVerticesOf()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1));
        NumberVertex v4 = NumberVertex.of(2);
        NumberVertex v5 = NumberVertex.of(5);
        NumberEdge e2 = NumberEdge.of(v4, v5);
        Graph g2 = Graph.of(new OrionHashSet<>(v4, v5), new OrionHashSet<>(e2));
        Graph result = GraphService.joinVerticesToVerticesOf(g2, g1);
        OrionSet<Vertex> expectedVertices = OrionHashSet.<Vertex>of(v1, v2, v3, v5);
        NumberEdge e3 = NumberEdge.of(v4, v1);
        NumberEdge e4 = NumberEdge.of(v4, v2);
        NumberEdge e5 = NumberEdge.of(v4, v3);
        NumberEdge e6 = NumberEdge.of(v5, v1);
        NumberEdge e7 = NumberEdge.of(v5, v2);
        NumberEdge e8 = NumberEdge.of(v5, v3);
        OrionSet<Edge> expectedEdges = OrionHashSet.<Edge>of(e3, e4, e5, e6, e7, e8);
        assertTrue(expectedVertices.equals(result.getVertices()));
        assertTrue(expectedEdges.equals(result.getEdges()));
    }


    @Test
    public void getDegreeOf()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        NumberEdge e2 = NumberEdge.of(v2, v3);
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1, e2));
        ANumber result = GraphService.getDegreeOf(g1, v2);
        assertTrue(ANumber.of(2).equal(result));
    }


    @Test
    public void isVertexIsolated()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberVertex v4 = NumberVertex.of(4);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        NumberEdge e2 = NumberEdge.of(v2, v3);
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3, v4), new OrionHashSet<>(e1, e2));
        boolean result = GraphService.isVertexIsolated(g1, v4);
        assertTrue(result);
        result = GraphService.isVertexIsolated(g1, v2);
        assertFalse(result);
    }


    @Test
    public void getAllPossibleSubgraphs()
    {
        NumberVertex v1 = NumberVertex.of(1);
        NumberVertex v2 = NumberVertex.of(2);
        NumberVertex v3 = NumberVertex.of(3);
        NumberEdge e1 = NumberEdge.of(v1, v2);
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3), new OrionHashSet<>(e1));
        Graph[] result = GraphService.getAllPossibleSubgraphs(g1);
        assertTrue(result.length == 7);
        assertTrue(result[0].getVerticesAsArray().length == 1);
        assertTrue(result[0].getVerticesAsArray()[0].getVertexPoint().equals(ANumber.of(1)));
        assertTrue(result[0].getEdges().isEmpty());
        assertTrue(result[1].getVerticesAsArray().length == 1);
        assertTrue(result[1].getVerticesAsArray()[0].getVertexPoint().equals(ANumber.of(2)));
        assertTrue(result[1].getEdges().isEmpty());
        assertTrue(result[2].getVerticesAsArray().length == 1);
        assertTrue(result[2].getVerticesAsArray()[0].getVertexPoint().equals(ANumber.of(3)));
        assertTrue(result[2].getEdges().isEmpty());
        assertTrue(result[3].getVerticesAsArray().length == 2);
        assertTrue(result[3].getVerticesAsArray()[0].getVertexPoint().equals(ANumber.of(1)));
        assertTrue(result[3].getVerticesAsArray()[1].getVertexPoint().equals(ANumber.of(2)));
        assertTrue(result[3].getEdgesAsArray().length == 1);
        assertTrue(result[3].getEdgesAsArray()[0].getFirst().getVertexPoint().equals(ANumber.of(1)));
        assertTrue(result[3].getEdgesAsArray()[0].getSecond().getVertexPoint().equals(ANumber.of(2)));
        assertTrue(result[4].getVerticesAsArray().length == 2);
        assertTrue(result[4].getVerticesAsArray()[0].getVertexPoint().equals(ANumber.of(1)));
        assertTrue(result[4].getVerticesAsArray()[1].getVertexPoint().equals(ANumber.of(3)));
        assertTrue(result[4].getEdgesAsArray().length == 1);
        assertTrue(result[4].getEdgesAsArray()[0].getFirst().getVertexPoint().equals(ANumber.of(1)));
        assertTrue(result[4].getEdgesAsArray()[0].getSecond().getVertexPoint().equals(ANumber.of(3)));
        assertTrue(result[5].getVerticesAsArray().length == 2);
        assertTrue(result[5].getVerticesAsArray()[0].getVertexPoint().equals(ANumber.of(2)));
        assertTrue(result[5].getVerticesAsArray()[1].getVertexPoint().equals(ANumber.of(3)));
        assertTrue(result[5].getEdgesAsArray().length == 1);
        assertTrue(result[5].getEdgesAsArray()[0].getFirst().getVertexPoint().equals(ANumber.of(2)));
        assertTrue(result[5].getEdgesAsArray()[0].getSecond().getVertexPoint().equals(ANumber.of(3)));
        assertTrue(result[6].getVerticesAsArray().length == 3);
        assertTrue(result[6].getVerticesAsArray()[0].getVertexPoint().equals(ANumber.of(1)));
        assertTrue(result[6].getVerticesAsArray()[1].getVertexPoint().equals(ANumber.of(2)));
        assertTrue(result[6].getVerticesAsArray()[2].getVertexPoint().equals(ANumber.of(3)));
        assertTrue(result[6].getEdgesAsArray().length == 3);
        assertTrue(result[6].getEdgesAsArray()[0].getFirst().getVertexPoint().equals(ANumber.of(1)));
        assertTrue(result[6].getEdgesAsArray()[0].getSecond().getVertexPoint().equals(ANumber.of(3)));
        assertTrue(result[6].getEdgesAsArray()[1].getFirst().getVertexPoint().equals(ANumber.of(1)));
        assertTrue(result[6].getEdgesAsArray()[1].getSecond().getVertexPoint().equals(ANumber.of(2)));
        assertTrue(result[6].getEdgesAsArray()[2].getFirst().getVertexPoint().equals(ANumber.of(2)));
        assertTrue(result[6].getEdgesAsArray()[2].getSecond().getVertexPoint().equals(ANumber.of(3)));
    }


    @Test
    public void doDepthFirstTraversal()
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
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3, v4, v5, v6), new OrionHashSet<>(e1, e2, e3, e4, e5));
        GraphService.doDepthFirstTraversal(g1, v1, (Vertex v) -> System.out.println(v.getVertexPoint()));
        //expected output = 1, 3, 6, 2, 5, 4
    }


    @Test
    public void doBreadthFirstTraversal()
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
        Graph g1 = Graph.of(new OrionHashSet<>(v1, v2, v3, v4, v5, v6), new OrionHashSet<>(e1, e2, e3, e4, e5));
        GraphService.doBreadthFirstTraversal(g1, v1, (Vertex v) -> System.out.println(v.getVertexPoint()));
        //expected output = 1, 3, 2, 6, 5, 4
    }


    @Test
    public void getPathsBetween()
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
        NumberEdge e6 = NumberEdge.of(v6, v3);
        Graph t1 = Graph.of(new OrionHashSet<>(v1, v2, v3, v4, v5, v6), new OrionHashSet<>(e1, e2, e3, e4, e5, e6));
        Path[] result = GraphService.getPathsBetween(t1, v1, v2);
        assertTrue(result.length == 1);
        assertTrue(result[0].getNumberOfEdges() == 1);
        assertTrue(result[0].getEdge(0).getFirst().equals(v1));
        assertTrue(result[0].getEdge(0).getSecond().equals(v2));
    }


    @Test
    public void getCycles()
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
        NumberEdge e6 = NumberEdge.of(v3, v1);
        NumberEdge e7 = NumberEdge.of(v5, v1);
        NumberEdge e8 = NumberEdge.of(v6, v3);
        Graph t1 = Graph.of(new OrionHashSet<>(v1, v2, v3, v4, v5, v6), new OrionHashSet<>(e1, e2, e3, e4, e5, e6, e7, e8));
        Path[] result = GraphService.getCycles(t1);
        assertTrue(result.length == 8);
    }
}