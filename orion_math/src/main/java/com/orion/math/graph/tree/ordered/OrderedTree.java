package com.orion.math.graph.tree.ordered;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.map.OrionMap;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.tree.Tree;
import com.orion.math.graph.tree.TreeRules;
import com.orion.math.graph.tree.TreeService;
import com.orion.math.graph.vertex.Vertex;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderedTree extends Tree
{
    private OrionMap<Vertex, OrionList<Edge>> vertexToOrderedEdgesMapper;


    public OrderedTree()
    {
        setEmpty(true);
        setHasRoot(false);
    }


    public OrderedTree(OrionMap<Vertex, OrionList<Edge>> vertexToOrderedEdgesMapper)
    {
        OrderedTreeRules.isValid(vertexToOrderedEdgesMapper);
        Set<Edge> edges = vertexToOrderedEdgesMapper.getValuesAsOrionList()
                        .stream()
                        .flatMap(list -> list.stream())
                        .collect(Collectors.toSet());
        setVertices(OrionHashSet.<Vertex>of(vertexToOrderedEdgesMapper.keySet()));
        setEdges(OrionHashSet.<Edge>of(edges));
        setRoot(TreeService.getRoot(this));
        setHasRoot(true);
    }


    public OrderedTree(OrionMap<Vertex, OrionList<Edge>> vertexToOrderedEdgesMapper, Vertex root)
    {
        OrderedTreeRules.isValid(vertexToOrderedEdgesMapper, root);
        Set<Edge> edges = vertexToOrderedEdgesMapper.getValuesAsOrionList()
                        .stream()
                        .flatMap(list -> list.stream())
                        .collect(Collectors.toSet());
        setVertices(OrionHashSet.<Vertex>of(vertexToOrderedEdgesMapper.keySet()));
        setEdges(OrionHashSet.<Edge>of(edges));
        setRoot(root);
        setHasRoot(true);
    }


    public static OrderedTree of()
    {
        return new OrderedTree();
    }


    public static OrderedTree of(OrionMap<Vertex, OrionList<Edge>> vertexToOrderedEdgesMapper)
    {
        return new OrderedTree(vertexToOrderedEdgesMapper);
    }


    public static OrderedTree of(OrionMap<Vertex, OrionList<Edge>> vertexToOrderedEdgesMapper, Vertex root)
    {
        return new OrderedTree(vertexToOrderedEdgesMapper, root);
    }


    public List<Vertex> getChildrenOfVertexInOrder(Vertex vertex)
    {
        TreeRules.isVertexInTree(this, vertex);
        return vertexToOrderedEdgesMapper.get(vertex).mapToList(edge -> edge.getSecond());
    }


    public List<Vertex> getSiblingsOfVertexInOrder(Vertex vertex)
    {
        List<Vertex> siblings = getChildrenOfVertexInOrder(vertex);
        siblings.remove(vertex);
        return siblings;
    }


    @Override
    public int hashCode()
    {
        return super.hashCode();
    }


    @Override
    public boolean equals(Object object)
    {
        return super.equals(object);
    }


    @Override
    public OrderedTree clone() throws CloneNotSupportedException
    {
        return (OrderedTree)CloningService.clone(this);
    }


    public OrderedTree getCopy()
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


    public OrionMap<Vertex, OrionList<Edge>> getVertexToOrderedEdgesMapper()
    {
        return this.vertexToOrderedEdgesMapper;
    }
}