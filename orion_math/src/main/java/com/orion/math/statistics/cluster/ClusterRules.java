package com.orion.math.statistics.cluster;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;

public class ClusterRules extends MathRule
{
    public static void isValid(OrionSet<Object> points, Object center)
    {
        Assert.notEmpty(points, "Cluster has no points.");
        Assert.notNull(center, "Cluster has no center point.");
    }


    public static void isValid(Cluster cluster)
    {
        Assert.notNull(cluster, "The cluster input cannor be null.");
        isValid(cluster.getPoints(), cluster.getCenter());
    }
}