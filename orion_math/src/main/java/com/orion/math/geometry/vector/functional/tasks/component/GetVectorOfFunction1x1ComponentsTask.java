package com.orion.math.geometry.vector.functional.tasks.component;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Service;
import java.util.stream.IntStream;

public class GetVectorOfFunction1x1ComponentsTask extends Orion
{
    public static VectorOfFunction1x1[] run(VectorOfFunction1x1 x)
    {
        VectorOfFunction1x1Rules.isValid(x);
        VectorOfFunction1x1[] vectors = new VectorOfFunction1x1[x.getDimensions()];
        IntStream.range(0, x.getDimensions()).forEach(i -> vectors[i] = VectorOfFunction1x1Service.getVectorComponent(x, i + 1));
        return vectors;
    }
}