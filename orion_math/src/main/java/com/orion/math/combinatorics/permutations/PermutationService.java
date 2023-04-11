package com.orion.math.combinatorics.permutations;

import com.orion.core.abstraction.OrionService;
import com.orion.math.combinatorics.permutations.tasks.GetCyclicPermutationsOfObjectsTask;
import com.orion.math.combinatorics.permutations.tasks.GetNumberOfPermutationsTask;
import com.orion.math.combinatorics.permutations.tasks.PermuteObjectsTask;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import java.util.List;

public class PermutationService extends OrionService
{
    public static List<List<?>> permute(List<?> elements)
    {
        return new PermuteObjectsTask().run(elements);
    }


    public static List<List<Object>> getCyclicPermutations(List<?> elements)
    {
        return GetCyclicPermutationsOfObjectsTask.run(elements);
    }


    public static ANumber getNumberOfPermutations(List<?> elements, ANumber numberOfElementsToSelect)
    {
        return GetNumberOfPermutationsTask.run(elements, numberOfElementsToSelect);
    }


    public static ANumber getNumberOfPermutationsWithDifferentTypesOfElements(List<?> elements, Vector numberOfElementsOfEachType)
    {
        return GetNumberOfPermutationsTask.run(elements, numberOfElementsOfEachType);
    }
}