package com.orion.math.geometry.vector.tasks.component;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.geometry.vector.VectorService;
import java.util.stream.IntStream;

public class GetVectorComponentsTask extends Orion
{
    public static Vector[] run(Vector x)
    {
        VectorRules.isValid(x);
        Vector[] vectors = new Vector[x.getDimensions()];
        IntStream.range(0, x.getDimensions()).forEach(i -> vectors[i] = VectorService.getVectorComponent(x, i + 1));
        return vectors;
    }
}