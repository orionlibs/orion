package com.orion.math.geometry.shape.polygon;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.polygon.tasks.PolygonEqualsTask;
import com.orion.math.geometry.shape.polygon.tasks.PolygonHashCodeTask;

class PolygonInternalService implements MathObject
{
    static boolean equals(Polygon x, Object y)
    {
        return PolygonEqualsTask.run(x, y);
    }


    static int hashCode(Polygon x)
    {
        return PolygonHashCodeTask.run(x);
    }
}