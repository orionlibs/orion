package com.orion.math.geometry.shape.circle.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.circle.CircleRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;

public class DoCirclesIntersectTask extends Orion
{
    public static boolean run(Circle x, Circle other)
    {
        CircleRules.areValid(x, other);
        ANumber minimum = x.getRadius().subtractGET(other.getRadius()).squareGET();
        ANumber maximum = x.getRadius().addGET(other.getRadius()).squareGET();
        ANumber between = x.getCenter().getX().subtractGET(other.getCenter().getX()).squareGET();
        between.add(x.getCenter().getY().subtractGET(other.getCenter().getY()).squareGET());
        return Numbers.isBetween(between, minimum, maximum);
    }
}