package com.orion.math.optimisation.combinatorial;

import com.orion.core.abstraction.OrionService;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.optimisation.combinatorial.tasks.SolveKnapsackProblemTask;
import java.util.List;

public class CombinatorialOptimisationService extends OrionService
{
    public static Pair<ANumber, List<Integer>> solveKnapsackProblem(int capacity, Vector weights, Vector values)
    {
        return SolveKnapsackProblemTask.run(capacity, weights, values);
    }
}