package com.orion.math.graph.tree;

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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Tree extends Graph
{
    private Vertex root;
    private boolean hasRoot;


    public Tree()
    {
        setEmpty(true);
        this.hasRoot = false;
    }


    public Tree(OrionSet<Vertex> vertices, OrionSet<Edge> edges, Vertex root)
    {
        TreeRules.isValid(vertices, edges, root);
        setVertices(vertices);
        setEdges(edges);
        this.root = root;
        this.hasRoot = true;
    }


    public Tree(Collection<Vertex> vertices, Collection<Edge> edges, Vertex root)
    {
        TreeRules.isValid(vertices, edges, root);
        setVertices(OrionHashSet.<Vertex>of(vertices));
        setEdges(OrionHashSet.<Edge>of(edges));
        this.root = root;
        this.hasRoot = true;
    }


    public Tree(OrionSet<Vertex> vertices, Collection<Edge> edges, Vertex root)
    {
        TreeRules.isValid(vertices, edges, root);
        setVertices(vertices);
        setEdges(OrionHashSet.<Edge>of(edges));
        this.root = root;
        this.hasRoot = true;
    }


    public Tree(Collection<Vertex> vertices, OrionSet<Edge> edges, Vertex root)
    {
        TreeRules.isValid(vertices, edges, root);
        setVertices(OrionHashSet.<Vertex>of(vertices));
        setEdges(edges);
        this.root = root;
        this.hasRoot = true;
    }


    public Tree(OrionSet<Vertex> vertices, OrionSet<Edge> edges) throws TreeHasMultipleRootsException
    {
        TreeRules.isValid(vertices, edges);
        setVertices(vertices);
        setEdges(edges);
        this.root = TreeService.getRoot(this);
        this.hasRoot = (getRoot().isEmpty()) ? false : true;
    }


    public Tree(Collection<Vertex> vertices, Collection<Edge> edges) throws TreeHasMultipleRootsException
    {
        OrionSet<Vertex> verticesTemp = OrionHashSet.<Vertex>of(vertices);
        OrionSet<Edge> edgesTemp = OrionHashSet.<Edge>of(edges);
        TreeRules.isValid(verticesTemp, edgesTemp);
        setVertices(verticesTemp);
        setEdges(edgesTemp);
        this.root = TreeService.getRoot(this);
        this.hasRoot = (getRoot().isEmpty()) ? false : true;
    }


    public Tree(OrionSet<Vertex> vertices, Collection<Edge> edges) throws TreeHasMultipleRootsException
    {
        OrionSet<Edge> edgesTemp = OrionHashSet.<Edge>of(edges);
        TreeRules.isValid(vertices, edgesTemp);
        setVertices(vertices);
        setEdges(edgesTemp);
        this.root = TreeService.getRoot(this);
        this.hasRoot = (getRoot().isEmpty()) ? false : true;
    }


    public Tree(Collection<Vertex> vertices, OrionSet<Edge> edges) throws TreeHasMultipleRootsException
    {
        OrionSet<Vertex> verticesTemp = OrionHashSet.<Vertex>of(vertices);
        TreeRules.isValid(verticesTemp, edges);
        setVertices(verticesTemp);
        setEdges(edges);
        this.root = TreeService.getRoot(this);
        this.hasRoot = (getRoot().isEmpty()) ? false : true;
    }


    public static Tree of()
    {
        return new Tree();
    }


    public static Tree of(OrionSet<Vertex> vertices, OrionSet<Edge> edges, Vertex root)
    {
        return new Tree(vertices, edges, root);
    }


    public static Tree of(Collection<Vertex> vertices, Collection<Edge> edges, Vertex root)
    {
        return new Tree(vertices, edges, root);
    }


    public static Tree of(OrionSet<Vertex> vertices, Collection<Edge> edges, Vertex root)
    {
        return new Tree(vertices, edges, root);
    }


    public static Tree of(Collection<Vertex> vertices, OrionSet<Edge> edges, Vertex root)
    {
        return new Tree(vertices, edges, root);
    }


    public static Tree of(OrionSet<Vertex> vertices, OrionSet<Edge> edges)
    {
        return new Tree(vertices, edges);
    }


    public static Tree of(Collection<Vertex> vertices, Collection<Edge> edges)
    {
        return new Tree(vertices, edges);
    }


    public static Tree of(OrionSet<Vertex> vertices, Collection<Edge> edges)
    {
        return new Tree(vertices, edges);
    }


    public static Tree of(Collection<Vertex> vertices, OrionSet<Edge> edges)
    {
        return new Tree(vertices, edges);
    }


    public Vertex[] getLeaves()
    {
        return TreeService.getLeaves(this);
    }


    public int getNumberOfLeaves()
    {
        return TreeService.getNumberOfLeaves(this);
    }


    public boolean isTrivial()
    {
        return TreeService.isTrivial(this);
    }


    public boolean isRoot(Vertex vertex)
    {
        return TreeService.isRoot(this, vertex);
    }


    public boolean isLeaf(Vertex vertex)
    {
        return TreeService.isLeaf(this, vertex);
    }


    public boolean isNotLeaf(Vertex vertex)
    {
        return !isLeaf(vertex);
    }


    public boolean isComparable()
    {
        return TreeService.isComparable(this);
    }


    public Vertex getImmediateParentOf(Vertex vertex)
    {
        return TreeService.getImmediateParentOf(this, vertex);
    }


    public boolean isImmediateParentOf(Vertex parent, Vertex child)
    {
        return getImmediateParentOf(child).equals(parent);
    }


    public Vertex[] getChildrenOf(Vertex vertex)
    {
        return TreeService.getChildrenOf(this, vertex);
    }


    public ANumber getNumberOfChildren(Vertex vertex)
    {
        return ANumber.of(getChildrenOf(vertex).length);
    }


    public boolean isImmediateChildOf(Vertex child, Vertex parent)
    {
        return isImmediateParentOf(parent, child);
    }


    public Edge getEdgeIncidentAtVertex(Vertex vertex)
    {
        return TreeService.getEdgeIncidentAtVertex(this, vertex);
    }


    public Vertex[] getSiblingsOf(Vertex vertex)
    {
        return TreeService.getSiblingsOf(this, vertex);
    }


    public ANumber getNumberOfSiblings(Vertex vertex)
    {
        return ANumber.of(getSiblingsOf(vertex).length);
    }


    public boolean areSiblings(Vertex v1, Vertex v2)
    {
        Vertex[] siblings = getSiblingsOf(v1);
        return Arrays.stream(siblings).anyMatch(sibling -> sibling.equals(v2));
    }


    public Vertex[] getAncestorsOf(Vertex vertex)
    {
        return TreeService.getAncestorsOf(this, vertex);
    }


    public ANumber getNumberOfAncestors(Vertex vertex)
    {
        return ANumber.of(getAncestorsOf(vertex).length);
    }


    public boolean isAncestorOf(Vertex ancestor, Vertex vertex)
    {
        Vertex[] ancestors = getAncestorsOf(vertex);
        return Arrays.stream(ancestors).anyMatch(ancestor1 -> ancestor1.equals(ancestor));
    }


    public Vertex[] getDescendantsOf(Vertex vertex)
    {
        return TreeService.getDescendantsOf(this, vertex);
    }


    public ANumber getNumberOfDescendants(Vertex vertex)
    {
        return ANumber.of(getDescendantsOf(vertex).length);
    }


    public boolean isDescendantOf(Vertex descendant, Vertex ancestor)
    {
        Vertex[] descendants = getDescendantsOf(ancestor);
        return Arrays.stream(descendants).anyMatch(descendant1 -> descendant1.equals(descendant));
    }


    public Tree getSubtreeWithRoot(Vertex newRoot)
    {
        return TreeService.getSubtreeWithRoot(this, newRoot);
    }


    public boolean isBinaryTree()
    {
        return TreeService.isBinaryTree(this);
    }


    public boolean isMAryTree(int m)
    {
        return TreeService.isMAryTree(this, m);
    }


    public Tree subtract(Vertex vertexToDelete)
    {
        Graph graph = GraphService.subtract(this, vertexToDelete);
        return Tree.of(graph.getVertices(), graph.getEdges());
    }


    public Tree subtract(Vertex[] verticesToDelete)
    {
        Graph graph = GraphService.subtract(this, verticesToDelete);
        return Tree.of(graph.getVertices(), graph.getEdges());
    }


    public Tree subtract(OrionSet<Vertex> verticesToDelete)
    {
        Graph graph = GraphService.subtract(this, verticesToDelete);
        return Tree.of(graph.getVertices(), graph.getEdges());
    }


    public Tree subtract(OrionList<Vertex> verticesToDelete)
    {
        Graph graph = GraphService.subtract(this, verticesToDelete);
        return Tree.of(graph.getVertices(), graph.getEdges());
    }


    public Tree subtractEdge(Edge edgeToDelete)
    {
        return TreeService.subtractEdge(this, edgeToDelete);
    }


    public Tree subtractEdges(Edge[] edgesToDelete)
    {
        return TreeService.subtractEdges(this, edgesToDelete);
    }


    public Tree subtractEdges(OrionSet<Edge> edgesToDelete)
    {
        return TreeService.subtractEdges(this, edgesToDelete);
    }


    public Tree subtractEdges(OrionList<Edge> edgesToDelete)
    {
        return TreeService.subtractEdges(this, edgesToDelete);
    }


    public ANumber getHeight()
    {
        return TreeService.getHeight(this);
    }


    public ANumber getHeightOfVertex(Vertex vertex)
    {
        return TreeService.getHeightOfVertex(this, vertex);
    }


    public boolean isBalanced()
    {
        return TreeService.isBalanced(this);
    }


    public boolean isCompleteMAryTree(int m)
    {
        return TreeService.isCompleteMAryTree(this, m);
    }


    public List<Vertex> getNonLeaves()
    {
        return getVertices().filter(vertex -> isNotLeaf(vertex)).collect(Collectors.toList());
    }


    public void doDepthFirstTraversal(Consumer<Vertex> action)
    {
        doDepthFirstTraversal(getRoot(), action);
    }


    public void doBreadthFirstTraversal(Consumer<Vertex> action)
    {
        doBreadthFirstTraversal(getRoot(), action);
    }


    public OrionList<Vertex> getNonLeavesAsOrionList()
    {
        return OrionArrayList.<Vertex>of(getNonLeaves());
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
    public Tree clone() throws CloneNotSupportedException
    {
        return (Tree)CloningService.clone(this);
    }


    public Tree getCopy()
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


    public Vertex getRoot()
    {
        return this.root;
    }


    public boolean isHasRoot()
    {
        return this.hasRoot;
    }


    protected void setHasRoot(boolean hasRoot)
    {
        this.hasRoot = hasRoot;
    }


    protected void setRoot(Vertex root)
    {
        this.root = root;
    }
}