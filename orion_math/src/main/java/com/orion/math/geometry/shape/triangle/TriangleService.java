package com.orion.math.geometry.shape.triangle;

import com.orion.core.abstraction.OrionService;
import com.orion.core.tuple.Triple;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.triangle.tasks.GetAreaOfTriangleTask;
import com.orion.math.geometry.shape.triangle.tasks.GetCentroidOfTriangleTask;
import com.orion.math.geometry.shape.triangle.tasks.GetCircumcenterOfTriangleTask;
import com.orion.math.geometry.shape.triangle.tasks.GetNumberOfSquaresThatCanFitInRightIsoscelesTriangleTask;
import com.orion.math.geometry.shape.triangle.tasks.GetNumberOfTriangleLatticePointsTask;
import com.orion.math.geometry.shape.triangle.tasks.GetTriangleAngleTypeTask;
import com.orion.math.geometry.shape.triangle.tasks.GetTriangleSideTypeTask;
import com.orion.math.geometry.shape.triangle.tasks.check.IsPointInsideOrOnTriangleTask;
import com.orion.math.geometry.shape.triangle.tasks.check.IsPointOnTriangleTask;
import com.orion.math.geometry.shape.triangle.tasks.check.IsTriangleSimilarToAnotherTask;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import java.util.Arrays;

public class TriangleService extends OrionService
{
    public static ANumber getPerimeter(Triangle x)
    {
        TriangleRules.isValid(x);
        return x.getLengthOfA().addGET(x.getLengthOfB()).addGET(x.getLengthOfC());
    }


    public static ANumber getHalfPerimeter(Triangle x)
    {
        return getPerimeter(x).halfGET();
    }


    public static ANumber getArea(Triangle x)
    {
        return GetAreaOfTriangleTask.run(x, Precision.precision);
    }


    public static ANumber getArea(Triangle x, int precision)
    {
        return GetAreaOfTriangleTask.run(x, precision);
    }


    public static ANumber getAreaGiven2AdjacentSides(Vector x, Vector y)
    {
        VectorRules.areValid(x, y);
        return x.getCrossProductMagnitude(y).halfGET();
    }


    public static ANumber getAreaGiven2AdjacentSides(Vector x, Vector y, int precision)
    {
        VectorRules.areValid(x, y);
        return x.getCrossProductMagnitude(y, precision).halfGET();
    }


    public static ANumber getHypotenuse(ANumber sideLength1, ANumber sideLength2)
    {
        return getHypotenuse(sideLength1, sideLength2, Precision.precision);
    }


    public static ANumber getHypotenuse(ANumber sideLength1, ANumber sideLength2, int precision)
    {
        NumberRules.areAllPositive(sideLength1, sideLength2);
        return sideLength1.squareGET().addGET(sideLength2.squareGET()).getSquareRoot(precision);
    }


    public static ANumber getHypotenuseIgnoreErrors(ANumber sideLength1, ANumber sideLength2)
    {
        return getHypotenuseIgnoreErrors(sideLength1, sideLength2, Precision.precision);
    }


    public static ANumber getHypotenuseIgnoreErrors(ANumber sideLength1, ANumber sideLength2, int precision)
    {
        NumberRules.areNotNull(sideLength1, sideLength2);
        return sideLength1.squareGET().addGET(sideLength2.squareGET()).getSquareRoot(precision);
    }


    public static boolean isPointInsideOrOnTriangle(Triangle x, Point other)
    {
        return IsPointInsideOrOnTriangleTask.run(x, other, Precision.precision);
    }


    public static boolean isPointInsideOrOnTriangle(Triangle x, Point other, int precision)
    {
        return IsPointInsideOrOnTriangleTask.run(x, other, precision);
    }


    public static boolean isPointOnTriangle(Triangle x, Point other)
    {
        return IsPointOnTriangleTask.run(x, other, Precision.precision);
    }


    public static boolean isPointOnTriangle(Triangle x, Point other, int precision)
    {
        return IsPointOnTriangleTask.run(x, other, precision);
    }


    public static ANumber getNumberOfLatticePoints(Triangle x)
    {
        return GetNumberOfTriangleLatticePointsTask.run(x);
    }


    public static ANumber getNumberOfIntegralPoints(Triangle x)
    {
        return getNumberOfLatticePoints(x);
    }


    public static TriangleSideType getSideType(Triangle x)
    {
        return GetTriangleSideTypeTask.run(x, Precision.precision);
    }


    public static TriangleSideType getSideType(Triangle x, int precision)
    {
        return GetTriangleSideTypeTask.run(x, precision);
    }


    public static TriangleAngleType getAngleType(Triangle x)
    {
        return GetTriangleAngleTypeTask.run(x);
    }


    public static ANumber getNumberOfSquaresThatCanFitInRightIsoscelesTriangle(Triangle x, ANumber squareSideLength)
    {
        return GetNumberOfSquaresThatCanFitInRightIsoscelesTriangleTask.run(x, squareSideLength);
    }


    public static ANumber getLengthOfSideUsingLawOfCosines(ANumber lengthOfSide1, ANumber lengthOfSide2, ANumber cosineOfSide1AndSide2)
    {
        NumberRules.areAllPositive(Arrays.asList(lengthOfSide1, lengthOfSide2));
        NumberRules.isNotNull(cosineOfSide1AndSide2);
        return lengthOfSide1.squareGET().addGET(lengthOfSide2.squareGET()).subtractGET(lengthOfSide1.multiplyGET(lengthOfSide2).multiplyGET(cosineOfSide1AndSide2).doubleGET());
    }


    public static ANumber getCosineBetweenSidesBAndCUsingLawOfCosines(ANumber lengthOfA, ANumber lengthOfB, ANumber lengthOfC)
    {
        NumberRules.areAllPositive(Arrays.asList(lengthOfA, lengthOfB, lengthOfC));
        return lengthOfB.squareGET().addGET(lengthOfC.squareGET()).subtractGET(lengthOfA.squareGET()).divideGET(lengthOfB.multiplyGET(lengthOfC).doubleGET());
    }


    public static ANumber getCosineBetweenSidesAAndBUsingLawOfCosines(ANumber lengthOfA, ANumber lengthOfB, ANumber lengthOfC)
    {
        NumberRules.areAllPositive(Arrays.asList(lengthOfA, lengthOfB, lengthOfC));
        return lengthOfA.squareGET().addGET(lengthOfB.squareGET()).subtractGET(lengthOfC.squareGET()).divideGET(lengthOfA.multiplyGET(lengthOfB).doubleGET());
    }


    public static ANumber getCosineBetweenSidesAAndCUsingLawOfCosines(ANumber lengthOfA, ANumber lengthOfB, ANumber lengthOfC)
    {
        NumberRules.areAllPositive(Arrays.asList(lengthOfA, lengthOfB, lengthOfC));
        return lengthOfA.squareGET().addGET(lengthOfC.squareGET()).subtractGET(lengthOfB.squareGET()).divideGET(lengthOfA.multiplyGET(lengthOfC).doubleGET());
    }


    public static ANumber getAngleBetweenSidesBAndCUsingLawOfCosines(ANumber lengthOfA, ANumber lengthOfB, ANumber lengthOfC)
    {
        return getCosineBetweenSidesBAndCUsingLawOfCosines(lengthOfA, lengthOfB, lengthOfC).getArccosine();
    }


    public static ANumber getAngleBetweenSidesBAndCUsingLawOfCosines(ANumber lengthOfA, ANumber lengthOfB, ANumber lengthOfC, int precision)
    {
        return getCosineBetweenSidesBAndCUsingLawOfCosines(lengthOfA, lengthOfB, lengthOfC).getArccosine(precision);
    }


    public static ANumber getAngleBetweenSidesAAndBUsingLawOfCosines(ANumber lengthOfA, ANumber lengthOfB, ANumber lengthOfC)
    {
        return getCosineBetweenSidesAAndBUsingLawOfCosines(lengthOfA, lengthOfB, lengthOfC).getArccosine();
    }


    public static ANumber getAngleBetweenSidesAAndBUsingLawOfCosines(ANumber lengthOfA, ANumber lengthOfB, ANumber lengthOfC, int precision)
    {
        return getCosineBetweenSidesAAndBUsingLawOfCosines(lengthOfA, lengthOfB, lengthOfC).getArccosine(precision);
    }


    public static ANumber getAngleBetweenSidesAAndCUsingLawOfCosines(ANumber lengthOfA, ANumber lengthOfB, ANumber lengthOfC)
    {
        return getCosineBetweenSidesAAndCUsingLawOfCosines(lengthOfA, lengthOfB, lengthOfC).getArccosine();
    }


    public static ANumber getAngleBetweenSidesAAndCUsingLawOfCosines(ANumber lengthOfA, ANumber lengthOfB, ANumber lengthOfC, int precision)
    {
        return getCosineBetweenSidesAAndCUsingLawOfCosines(lengthOfA, lengthOfB, lengthOfC).getArccosine(precision);
    }


    public static ANumber getAngleBetweenSidesBAndCUsingLawOfCosines(Triangle x)
    {
        return getAngleBetweenSidesBAndCUsingLawOfCosines(x, Precision.precision);
    }


    public static ANumber getAngleBetweenSidesBAndCUsingLawOfCosines(Triangle x, int precision)
    {
        TriangleRules.isValidIgnoringPoints(x);
        return getCosineBetweenSidesBAndCUsingLawOfCosines(x.getLengthOfA(), x.getLengthOfB(), x.getLengthOfC()).getArccosine(precision);
    }


    public static ANumber getAngleBetweenSidesAAndBUsingLawOfCosines(Triangle x)
    {
        return getAngleBetweenSidesAAndBUsingLawOfCosines(x, Precision.precision);
    }


    public static ANumber getAngleBetweenSidesAAndBUsingLawOfCosines(Triangle x, int precision)
    {
        TriangleRules.isValidIgnoringPoints(x);
        return getCosineBetweenSidesAAndBUsingLawOfCosines(x.getLengthOfA(), x.getLengthOfB(), x.getLengthOfC()).getArccosine(precision);
    }


    public static ANumber getAngleBetweenSidesAAndCUsingLawOfCosines(Triangle x)
    {
        return getAngleBetweenSidesAAndCUsingLawOfCosines(x, Precision.precision);
    }


    public static ANumber getAngleBetweenSidesAAndCUsingLawOfCosines(Triangle x, int precision)
    {
        TriangleRules.isValidIgnoringPoints(x);
        return getCosineBetweenSidesAAndCUsingLawOfCosines(x.getLengthOfA(), x.getLengthOfB(), x.getLengthOfC()).getArccosine(precision);
    }


    public static Triple<ANumber, ANumber, ANumber> getAnglesAsRadians(Triangle x)
    {
        return getAnglesAsRadians(x, Precision.precision);
    }


    public static Triple<ANumber, ANumber, ANumber> getAnglesAsRadians(Triangle x, int precision)
    {
        ANumber angleA = getAngleBetweenSidesBAndCUsingLawOfCosines(x, precision);
        ANumber angleB = getAngleBetweenSidesAAndCUsingLawOfCosines(x, precision);
        ANumber angleC = getAngleBetweenSidesAAndBUsingLawOfCosines(x, precision);
        return Triple.of(angleA, angleB, angleC);
    }


    public static Triple<ANumber, ANumber, ANumber> getAnglesAsDegrees(Triangle x)
    {
        TriangleRules.isValid(x);
        return Triple.of(x.getAngleAAsDegrees(), x.getAngleBAsDegrees(), x.getAngleCAsDegrees());
    }


    public static Point getCircumcenter(Triangle x)
    {
        return GetCircumcenterOfTriangleTask.run(x);
    }


    public static boolean isSimilarTo(Triangle x, Triangle other)
    {
        return IsTriangleSimilarToAnotherTask.run(x, other);
    }


    public static Point getCentroid(Triangle x)
    {
        return GetCentroidOfTriangleTask.run(x);
    }
}