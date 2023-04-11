package com.orion.math.graph.digraph;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphService;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.vertex.Vertex;
import com.orion.math.number.ANumber;
import java.util.Collection;

public class Digraph extends Graph
{
    public Digraph()
    {
        setEmpty(true);
    }


    public Digraph(OrionSet<Vertex> vertices, OrionSet<Edge> edges)
    {
        DigraphRules.isValid(vertices, edges);
        setVertices(vertices);
        setEdges(edges);
    }


    public Digraph(Collection<Vertex> vertices, Collection<Edge> edges)
    {
        DigraphRules.isValid(vertices, edges);
        setVertices(OrionHashSet.<Vertex>of(vertices));
        setEdges(OrionHashSet.<Edge>of(edges));
    }


    public Digraph(OrionSet<Vertex> vertices, Collection<Edge> edges)
    {
        DigraphRules.isValid(vertices, edges);
        setVertices(vertices);
        setEdges(OrionHashSet.<Edge>of(edges));
    }


    public Digraph(Collection<Vertex> vertices, OrionSet<Edge> edges)
    {
        DigraphRules.isValid(vertices, edges);
        setVertices(OrionHashSet.<Vertex>of(vertices));
        setEdges(edges);
    }


    public static Digraph of()
    {
        return new Digraph();
    }


    public static Digraph of(OrionSet<Vertex> vertices, OrionSet<Edge> edges)
    {
        return new Digraph(vertices, edges);
    }


    public static Digraph of(Collection<Vertex> vertices, Collection<Edge> edges)
    {
        return new Digraph(vertices, edges);
    }


    public static Digraph of(OrionSet<Vertex> vertices, Collection<Edge> edges)
    {
        return new Digraph(vertices, edges);
    }


    public static Digraph of(Collection<Vertex> vertices, OrionSet<Edge> edges)
    {
        return new Digraph(vertices, edges);
    }


    public Digraph subtract(Vertex[] verticesToDelete)
    {
        return (Digraph)GraphService.subtract(this, verticesToDelete);
    }


    public Digraph subtract(Vertex vertexToDelete)
    {
        return (Digraph)GraphService.subtract(this, vertexToDelete);
    }


    public Digraph subtract(OrionSet<Vertex> verticesToDelete)
    {
        return (Digraph)GraphService.subtract(this, verticesToDelete);
    }


    public Digraph subtract(OrionList<Vertex> verticesToDelete)
    {
        return (Digraph)GraphService.subtract(this, verticesToDelete);
    }


    public Digraph subtractEdge(Edge edgeToDelete)
    {
        return (Digraph)GraphService.subtractEdge(this, edgeToDelete);
    }


    public Digraph subtractEdges(Edge[] edgesToDelete)
    {
        return (Digraph)GraphService.subtractEdges(this, edgesToDelete);
    }


    public Digraph subtractEdges(OrionSet<Edge> edgesToDelete)
    {
        return (Digraph)GraphService.subtractEdges(this, edgesToDelete);
    }


    public Digraph subtractEdges(OrionList<Edge> edgesToDelete)
    {
        return (Digraph)GraphService.subtractEdges(this, edgesToDelete);
    }


    public Digraph getComplement()
    {
        return DigraphService.getComplement(this);
    }


    public Digraph[] getAllPossibleSubgraphs()
    {
        return DigraphService.getAllPossibleSubgraphs(this);
    }


    public OrionList<Digraph> getAllPossibleSubgraphsOfDigraphAsList()
    {
        return OrionArrayList.<Digraph>of(getAllPossibleSubgraphs());
    }


    public boolean isKConnected(ANumber k)
    {
        return DigraphService.isKConnected(this, k);
    }


    public boolean isLEdgeConnected(ANumber l)
    {
        return DigraphService.isLEdgeConnected(this, l);
    }


    public Edge[] getDirectedEdgesThatInclude(Vertex firstVertex, Vertex secondVertex)
    {
        return DigraphService.getDirectedEdgesThatInclude(this, firstVertex, secondVertex);
    }


    public boolean isOriented()
    {
        return DigraphService.isOriented(this);
    }


    @Override
    public int hashCode()
    {
        return super.hashCode();
    }


    @Override
    public boolean equals(Object object)
    {
        return DigraphInternalService.equals(this, object);
    }


    @Override
    public Digraph clone() throws CloneNotSupportedException
    {
        return (Digraph)CloningService.clone(this);
    }


    public Digraph getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}