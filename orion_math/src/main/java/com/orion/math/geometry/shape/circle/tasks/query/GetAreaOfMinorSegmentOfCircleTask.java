package com.orion.math.geometry.shape.circle.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.circle.CircleRules;
import com.orion.math.geometry.shape.circle.chord.CircleChord;
import com.orion.math.geometry.shape.circle.chord.CircleChordRules;
import com.orion.math.geometry.shape.circle.sector.CircleSector;
import com.orion.math.geometry.shape.triangle.Triangle;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class GetAreaOfMinorSegmentOfCircleTask extends Orion
{
    public static ANumber run(Circle circle, CircleChord chord, int precision)
    {
        CircleRules.isValid(circle);
        CircleChordRules.isValid(chord);
        precision = Precision.getValidPrecision(precision);
        CircleSector sector = circle.getSectorFromChord(chord);
        Triangle triangle = Triangle.of(circle.getCenter(), chord.getStartPoint(), chord.getEndPoint());
        return triangle.getArea().subtractGET(sector.getArea()).getAbsoluteValue();
    }
}