package com.orion.math.geometry.vector.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class TranslateVectorTask extends Orion
{
    public static Vector run(Vector x, ANumber translationLength)
    {
        VectorRules.isValid(x);
        NumberRules.isNotNull(translationLength);
        ANumber[] startPointCoordinates = new ANumber[x.getDimensions()];
        ANumber[] endPointCoordinates = new ANumber[x.getDimensions()];
        x.forAllIndices(i ->
        {
            startPointCoordinates[i] = x.getStartPoint().get(i).addGET(translationLength);
            endPointCoordinates[i] = x.getEndPoint().get(i).addGET(translationLength);
        });
        return Vector.of(Point.of(startPointCoordinates), Point.of(endPointCoordinates));
    }
}