package com.orion.math.graph.tree.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.graph.tree.Tree;
import com.orion.math.graph.tree.TreeRules;
import com.orion.math.number.ANumber;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IsCompleteMAryTreeTask extends Orion
{
    public static boolean run(Tree tree, int m)
    {
        TreeRules.isValid(tree);
        tree.isMAryTree(m);
        List<ANumber> heightsOfLeaves = Arrays.stream(tree.getLeaves())
                        .map(leaf -> tree.getHeightOfVertex(leaf))
                        .collect(Collectors.toList());
        ANumber height = heightsOfLeaves.get(0);
        return !heightsOfLeaves.stream().anyMatch(heightOfLeaf -> heightOfLeaf.notEqual(height));
    }
}