package com.orion.math.set.relation.binary.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.interpolation.InterpolationService;
import com.orion.math.number.ANumber;
import com.orion.math.set.relation.binary.BinaryRelation;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateFunctionForBinaryRelationTask extends Orion
{
    public static Function1x1<ANumber, ANumber> run(BinaryRelation x)
    {

        if(x.getElements().findAny(pair -> pair.getFirst() instanceof ANumber == false || pair.getSecond() instanceof ANumber == false))
        {
            throw new InvalidArgumentException("I cannot calculate the function, because this relation does not consist only of ANumber objects.");
        }
        else
        {
            List<ANumber> xValues = x.getElements().stream().map(pair -> (ANumber)pair.getFirst()).collect(Collectors.toList());
            List<ANumber> yValues = x.getElements().stream().map(pair -> (ANumber)pair.getSecond()).collect(Collectors.toList());
            return InterpolationService.doPolynomialInterpolation(Vector.of(xValues), Vector.of(yValues)).getAsFunction();
        }

    }
}