package com.orion.math.geometry.vector.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class GetMidpointOfVectorTask extends Orion
{
    public static Point run(Vector x)
    {
        VectorRules.isValid(x);
        ANumber[] coordinates = new ANumber[x.getDimensions()];
        IntStream.range(0, x.getDimensions())
                        .forEach(i -> coordinates[i] = x.getEndPointCoordinates()[i].addGET(x.getStartPointCoordinates()[i]).halfGET());
        return Point.of(coordinates);
    }
}