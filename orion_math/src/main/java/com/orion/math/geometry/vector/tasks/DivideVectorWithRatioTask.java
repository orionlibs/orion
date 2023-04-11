package com.orion.math.geometry.vector.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.fraction.Fraction;
import java.util.stream.IntStream;

public class DivideVectorWithRatioTask extends Orion
{
    public static Pair<Vector, Vector> run(Vector x, ANumber ratio)
    {
        VectorRules.isValid(x);
        NumberRules.isPositive(ratio);
        Vector first = null;
        Vector second = null;
        Point ratioPoint = null;

        if(ratio.isOne())
        {
            ratioPoint = x.getMidpoint();
        }
        else
        {
            Fraction ratioAsFraction = ratio.getAsFraction();
            ANumber numerator = ratioAsFraction.getNumeratorAsNumber();
            ANumber denominator = ratioAsFraction.getNumeratorAsNumber().addGET(ratioAsFraction.getDenominatorAsNumber());
            ANumber[] coordinates = new ANumber[x.getSize()];
            IntStream.range(0, coordinates.length)
                            .forEach(i -> coordinates[i] = x.getEndPoint().get(i).subtractGET(x.getStartPoint().get(i)).multiplyGET(numerator).divideGET(denominator));
            ratioPoint = Point.of(coordinates);
        }

        first = Vector.of(x.getStartPointCopy(), ratioPoint.getCopy());
        second = Vector.of(ratioPoint.getCopy(), x.getEndPointCopy());
        return Pair.of(first, second);
    }
}