package com.orion.math.geometry.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.ANumber;
import java.util.HashMap;
import java.util.Map;

public class GetNumberOfParallelogramsFormedByPointsTask extends Orion
{
    public static ANumber run(Point[] points)
    {
        PointRules.areValid(points);
        Map<Pair<Integer, Integer>, Integer> count = new HashMap<Pair<Integer, Integer>, Integer>();

        for(int i = 0; i < points.length - 1; i++)
        {

            for(int j = i + 1; j < points.length; j++)
            {
                ANumber midX = points[i].getX().addGET(points[j].getX());
                ANumber midY = points[i].getY().addGET(points[j].getY());
                Pair<Integer, Integer> pair = Pair.of(midX.getAsInt(), midY.getAsInt());

                if(count.get(pair) != null)
                {
                    count.put(pair, count.get(pair) + 1);
                }
                else
                {
                    count.put(pair, 1);
                }

            }

        }

        int result = 0;

        for(Map.Entry<Pair<Integer, Integer>, Integer> entry : count.entrySet())
        {
            result += entry.getValue() * (entry.getValue() - 1) / 2;
        }

        return ANumber.of(result);
    }
}