package com.orion.math.geometry.point.tasks.relocation;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class TranslatePointTask extends Orion
{
    public static Point run(Point p, ANumber x)
    {
        PointRules.isValid(p);
        NumberRules.isNotNull(x);
        ANumber[] coordinates = p.getCoordinatesCopy();
        Arrays.stream(coordinates).forEach(c -> c.add(x));
        return Point.of(coordinates);
    }
}