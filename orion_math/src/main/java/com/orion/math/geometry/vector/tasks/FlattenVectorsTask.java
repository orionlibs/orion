package com.orion.math.geometry.vector.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FlattenVectorsTask extends Orion
{
    public static List<ANumber> run(List<Vector> vectors)
    {
        VectorRules.areValid(vectors);
        int sumOfDimensions = vectors.stream().map(v -> v.getDimensions()).reduce(0, (Integer dim1, Integer dim2) -> dim1 + dim2);
        List<ANumber> numbers = new ArrayList<ANumber>(sumOfDimensions);
        IntStream.range(0, vectors.size()).forEach(i -> numbers.addAll(vectors.get(i).getAsList()));
        return numbers;
    }
}