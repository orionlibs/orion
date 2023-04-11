package com.orion.math.geometry.point.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.services.NumberService;

public class GetNumberOfLatticePointsBetween2PointsTask extends Orion
{
    public static ANumber run(Point p, Point other, boolean includeGivenPointsInCalculation)
    {
        PointRules.areValid(p, other);
        ANumber numberOfLatticePoints = ANumber.of(0);

        if(p.getX() == other.getX())
        {
            numberOfLatticePoints = p.getY().subtractGET(other.getY()).getAbsoluteValue().subtractOneGET();
        }
        else if(p.getY() == other.getY())
        {
            numberOfLatticePoints = p.getX().subtractGET(other.getX()).getAbsoluteValue().subtractOneGET();
        }
        else
        {
            ANumber a = p.getX().subtractGET(other.getX()).getAbsoluteValue().getFloor();
            ANumber b = p.getY().subtractGET(other.getY()).getAbsoluteValue().getFloor();
            numberOfLatticePoints.add(NumberService.getGreatestCommonDivisor(a, b).subtractOneGET());
        }

        includeGivenPointsInCalculation(p, other, numberOfLatticePoints, includeGivenPointsInCalculation);
        return numberOfLatticePoints;
    }


    private static void includeGivenPointsInCalculation(Point p, Point other, ANumber numberOfLatticePoints, boolean includeGivenPointsInCalculation)
    {

        if(includeGivenPointsInCalculation)
        {

            if(p.getX().hasIntegerValue() && p.getY().hasIntegerValue())
            {
                numberOfLatticePoints.add(1);
            }

            if(other.getX().hasIntegerValue() && other.getY().hasIntegerValue())
            {
                numberOfLatticePoints.add(1);
            }

        }

    }
}