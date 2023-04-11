package com.orion.math.graph.tree.labeled;

import com.orion.core.data.structure.map.OrionMap;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.object.CloningService;
import com.orion.math.graph.edge.Edge;
import com.orion.math.graph.tree.Tree;
import com.orion.math.graph.tree.TreeRules;
import com.orion.math.graph.tree.TreeService;
import com.orion.math.graph.vertex.Vertex;

public class LabeledTree extends Tree
{
    private OrionMap<Vertex, Object> vertexToLabelMapper;


    public LabeledTree()
    {
        setEmpty(true);
        setHasRoot(false);
    }


    public LabeledTree(OrionSet<Vertex> vertices, OrionSet<Edge> edges, OrionMap<Vertex, Object> vertexToLabelMapper)
    {
        LabeledTreeRules.isValid(vertices, edges, vertexToLabelMapper);
        setVertices(vertices);
        setEdges(edges);
        setRoot(TreeService.getRoot(this));
        setHasRoot(true);
        this.vertexToLabelMapper = vertexToLabelMapper;
    }


    public LabeledTree(OrionSet<Vertex> vertices, OrionSet<Edge> edges, OrionMap<Vertex, Object> vertexToLabelMapper, Vertex root)
    {
        LabeledTreeRules.isValid(vertices, edges, vertexToLabelMapper);
        setVertices(vertices);
        setEdges(edges);
        setRoot(root);
        setHasRoot(true);
        this.vertexToLabelMapper = vertexToLabelMapper;
    }


    public static LabeledTree of()
    {
        return new LabeledTree();
    }


    public static LabeledTree of(OrionSet<Vertex> vertices, OrionSet<Edge> edges, OrionMap<Vertex, Object> vertexToLabelMapper)
    {
        return new LabeledTree(vertices, edges, vertexToLabelMapper);
    }


    public static LabeledTree of(OrionSet<Vertex> vertices, OrionSet<Edge> edges, OrionMap<Vertex, Object> vertexToLabelMapper, Vertex root)
    {
        return new LabeledTree(vertices, edges, vertexToLabelMapper, root);
    }


    public Object getLabelOfVertex(Vertex vertex)
    {
        TreeRules.isVertexInTree(this, vertex);
        return vertexToLabelMapper.get(vertex);
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
    public LabeledTree clone() throws CloneNotSupportedException
    {
        return (LabeledTree)CloningService.clone(this);
    }


    public LabeledTree getCopy()
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


    public OrionMap<Vertex, Object> getVertexToLabelMapper()
    {
        return this.vertexToLabelMapper;
    }
}