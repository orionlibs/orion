package com.orion.math.geometry.shape.polygon.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.polygon.Polygon;
import com.orion.math.geometry.shape.polygon.PolygonRules;
import com.orion.math.number.ANumber;

public class GetPolygonAreaTask extends Orion
{
    public static ANumber run(Polygon polygon)
    {
        PolygonRules.isValid(polygon);
        ANumber sum1 = ANumber.of(0);
        ANumber sum2 = ANumber.of(0);

        for(int i = 0; i < polygon.getNumberOfVertices(); i++)
        {

            if(i == polygon.getNumberOfVertices() - 1)
            {
                sum1.add(polygon.get(i).getX().multiplyGET(polygon.get(0).getY()));
                sum2.add(polygon.get(i).getY().multiplyGET(polygon.get(0).getX()));
            }
            else
            {
                sum1.add(polygon.get(i).getX().multiplyGET(polygon.get(i + 1).getY()));
                sum2.add(polygon.get(i).getY().multiplyGET(polygon.get(i + 1).getX()));
            }

        }

        return sum2.subtractGET(sum1).halfGET().getAbsoluteValue();
    }
}