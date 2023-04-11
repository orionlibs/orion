package com.orion.math.geometry.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;

public class GetNumberOfHorizontalOrVerticalLineSegmentsToConnectPointsTask extends Orion
{
    public static ANumber run(Point point1, Point point2, Point point3)
    {
        PointRules.areValid(point1, point2, point3);

        if((point1.getX().equal(point2.getX()) && point2.getX().equal(point3.getX()))
                        || (point1.getY().equal(point2.getY()) && point2.getY().equal(point3.getY())))
        {
            return ANumber.of(1);
        }
        else if(canJoin(point1, point2, point3, 0, 1, 2)
                        || canJoin(point1, point2, point3, 0, 2, 1)
                        || canJoin(point1, point2, point3, 1, 2, 0))
        {
            return ANumber.of(2);
        }
        else
        {
            return ANumber.of(3);
        }

    }


    private static boolean canJoin(Point point1, Point point2, Point point3, int i, int j, int k)
    {

        if(i == 0 && j == 1 && k == 2)
        {
            return (point3.getX().equal(point1.getX())
                            || point3.getX().equal(point2.getX()))
                            && Numbers.isBetween(point3.getY(), point1.getY(), point2.getY()) || (point3.getY().equal(point1.getY()) || point3.getY().equal(point2.getY())) && Numbers.isBetween(point3.getX(), point1.getX(), point2.getX());
        }
        else if(i == 0 && j == 2 && k == 1)
        {
            return (point2.getX().equal(point1.getX())
                            || point2.getX().equal(point3.getX()))
                            && Numbers.isBetween(point2.getY(), point1.getY(), point3.getY()) || (point2.getY().equal(point1.getY()) || point2.getY().equal(point3.getY())) && Numbers.isBetween(point2.getX(), point1.getX(), point3.getX());
        }
        else
        {
            return (point1.getX().equal(point2.getX())
                            || point1.getX().equal(point3.getX()))
                            && Numbers.isBetween(point1.getY(), point2.getY(), point3.getY()) || (point1.getY().equal(point2.getY()) || point1.getY().equal(point3.getY())) && Numbers.isBetween(point1.getX(), point2.getX(), point3.getX());
        }

    }
}