package com.orion.math.geometry.vector.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class GetEqualVectorBasedOnPointTask extends Orion
{
    public static Vector run(Vector x, Point point)
    {
        VectorRules.isValid(x);
        PointRules.doDimensionsMatch(x.getEndPoint(), point);
        ANumber[] endPointCoordinates = new ANumber[x.getDimensions()];
        IntStream.range(0, x.getDimensions())
                        .forEach(i -> endPointCoordinates[i] = point.get(i).addGET(x.getEndPointCoordinates()[i].subtractGET(x.getStartPointCoordinates()[i])));
        return Vector.of(point.getCopy(), Point.of(endPointCoordinates));
    }
}