package com.orion.math.geometry.shape.circle;

import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.polar.PolarPoint;
import com.orion.math.geometry.shape.circle.chord.CircleChord;
import com.orion.math.geometry.shape.circle.chord.CircleChordRules;
import com.orion.math.geometry.shape.circle.sector.CircleSector;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;
import java.util.concurrent.atomic.AtomicInteger;

public class Circle implements MathObject, Cloneable
{
    private Point center;
    private PolarPoint centerPolarPoint;
    private ANumber radius;
    private Function2x1<ANumber, ANumber, ANumber> formula;
    private Function2x1<ANumber, ANumber, ANumber> formulaPolarForm;


    public Circle(Point center, ANumber radius)
    {
        this(center, radius, Precision.precision);
    }


    public Circle(Point center, ANumber radius, int precision)
    {
        CircleRules.isValid(center, radius);
        precision = Precision.getValidPrecision(precision);
        this.center = center;
        this.radius = radius;
        this.centerPolarPoint = center.getAsPolarPoint(precision);
        buildFormulaBasedOnCenterAndRadius();
        buildFormulaPolarForm(precision);
    }


    public Circle(Point diameterStartPoint, Point diameterEndPoint)
    {
        this(diameterStartPoint, diameterEndPoint, Precision.precision);
    }


    public Circle(Point diameterStartPoint, Point diameterEndPoint, int precision)
    {
        CircleRules.isValid(diameterStartPoint, diameterEndPoint);
        precision = Precision.getValidPrecision(precision);
        LineSegment diameter = LineSegment.of(diameterStartPoint, diameterEndPoint);
        this.center = diameter.getMidpoint();
        this.radius = diameter.getLength().halfGET();
        this.centerPolarPoint = center.getAsPolarPoint(precision);
        buildFormulaBasedOnRadius();
        buildFormulaPolarForm(precision);
    }


    public Circle(PolarPoint centerPolar, ANumber angleWithXAxis, ANumber radius)
    {
        this(centerPolar, angleWithXAxis, radius, Precision.precision);
    }


    public Circle(PolarPoint centerPolar, ANumber angleWithXAxis, ANumber radius, int precision)
    {
        CircleRules.isValid(centerPolar, angleWithXAxis, radius);
        precision = Precision.getValidPrecision(precision);
        this.center = centerPolar.getAsPoint();
        this.radius = radius;
        this.centerPolarPoint = centerPolar;
        buildFormulaBasedOnCenterAndRadius();
        buildFormulaPolarForm(precision);
    }


    public Circle(Point point1, Point point2, Point point3)
    {
        this(point1, point2, point3, Precision.precision);
    }


    public Circle(Point point1, Point point2, Point point3, int precision)
    {
        CircleRules.isValid(point1, point2, point3);
        precision = Precision.getValidPrecision(precision);
        LineSegment line1 = LineSegment.of(point1, point2);
        LineSegment line2 = LineSegment.of(point1, point3);
        Line perpendicularBisector1 = line1.getPerpendicularBisector();
        Line perpendicularBisector2 = line2.getPerpendicularBisector();
        this.center = perpendicularBisector1.getIntersectionPoint(perpendicularBisector2);
        this.radius = point1.getDistanceFromPoint(center);
        this.centerPolarPoint = center.getAsPolarPoint(precision);
        buildFormulaBasedOnRadius();
        buildFormulaPolarForm(precision);
    }


    public static Circle of(Point center, ANumber radius)
    {
        return new Circle(center, radius);
    }


    public static Circle of(Point center, ANumber radius, int precision)
    {
        return new Circle(center, radius, precision);
    }


    public static Circle of(Point diameterStartPoint, Point diameterEndPoint)
    {
        return new Circle(diameterStartPoint, diameterEndPoint);
    }


    public static Circle of(Point diameterStartPoint, Point diameterEndPoint, int precision)
    {
        return new Circle(diameterStartPoint, diameterEndPoint, precision);
    }


    public static Circle of(PolarPoint centerPolar, ANumber angleWithXAxis, ANumber radius)
    {
        return new Circle(centerPolar, angleWithXAxis, radius);
    }


    public static Circle of(PolarPoint centerPolar, ANumber angleWithXAxis, ANumber radius, int precision)
    {
        return new Circle(centerPolar, angleWithXAxis, radius, precision);
    }


    public static Circle of(Point point1, Point point2, Point point3)
    {
        return new Circle(point1, point2, point3);
    }


    public static Circle of(Point point1, Point point2, Point point3, int precision)
    {
        return new Circle(point1, point2, point3, precision);
    }


    public static Circle ofUnitCircle(Point center)
    {
        return new Circle(center, ANumber.of(1));
    }


    public static Circle ofUnitCircle(Point center, int precision)
    {
        return new Circle(center, ANumber.of(1), precision);
    }


    private void buildFormulaBasedOnCenterAndRadius()
    {
        Function2x1IF<ANumber, ANumber, ANumber> formulaFunction = (ANumber x, ANumber y) ->
        {
            return x.subtractGET(center.getX()).squareGET().addGET(y.subtractGET(center.getY()).squareGET()).subtractGET(radius.squareGET());
        };
        formula = new Function2x1<ANumber, ANumber, ANumber>(formulaFunction);
    }


    private void buildFormulaBasedOnRadius()
    {
        Function2x1IF<ANumber, ANumber, ANumber> formulaFunction = (ANumber x, ANumber y) ->
        {
            return x.squareGET().addGET(y.squareGET()).subtractGET(radius.squareGET());
        };
        formula = new Function2x1<ANumber, ANumber, ANumber>(formulaFunction);
    }


    private void buildFormulaPolarForm(int precision)
    {
        AtomicInteger precision2 = new AtomicInteger(precision);
        Function2x1IF<ANumber, ANumber, ANumber> formulaPolarFormFunction = (ANumber r, ANumber angle) ->
        {
            ANumber angleDifferenceCosine = angle.subtractGET(centerPolarPoint.getAngleWithXAxis()).getCosine(precision2.get());
            return r.squareGET().subtractGET(r.multiplyGET(centerPolarPoint.getDistanceFromPointOfOrigin()).multiplyGET(angleDifferenceCosine).doubleGET()).addGET(centerPolarPoint.getDistanceFromPointOfOrigin().squareGET()).subtractGET(radius.squareGET());
        };
        formulaPolarForm = new Function2x1<ANumber, ANumber, ANumber>(formulaPolarFormFunction);
    }


    public ANumber getCircumference()
    {
        return CircleService.getCircumference(this);
    }


    public ANumber getArea()
    {
        return CircleService.getArea(this);
    }


    public ANumber getPositiveYBasedOnX(ANumber x)
    {
        return CircleService.getPositiveYBasedOnX(this, x);
    }


    public ANumber getPositiveYBasedOnX(ANumber x, int precision)
    {
        return CircleService.getPositiveYBasedOnX(this, x, precision);
    }


    public ANumber getNegativeYBasedOnX(ANumber x)
    {
        return CircleService.getNegativeYBasedOnX(this, x);
    }


    public ANumber getNegativeYBasedOnX(ANumber x, int precision)
    {
        return CircleService.getNegativeYBasedOnX(this, x, precision);
    }


    public Pair<ANumber, ANumber> getYBasedOnX(ANumber x)
    {
        return Pair.of(getPositiveYBasedOnX(x), getNegativeYBasedOnX(x));
    }


    public Pair<ANumber, ANumber> getYBasedOnX(ANumber x, int precision)
    {
        return Pair.of(getPositiveYBasedOnX(x, precision), getNegativeYBasedOnX(x, precision));
    }


    public boolean isPointInsideCircle(Point other)
    {
        return CircleService.isPointInsideCircle(this, other);
    }


    public boolean isPointInsideCircle(Point other, int precision)
    {
        return CircleService.isPointInsideCircle(this, other, precision);
    }


    public boolean isPointOnCircle(Point other)
    {
        return CircleService.isPointOnCircle(this, other);
    }


    public boolean isPointOnCircle(Point other, int precision)
    {
        return CircleService.isPointOnCircle(this, other, precision);
    }


    public boolean isPointInsideOrOnCircle(Point other)
    {
        return CircleService.isPointInsideOrOnCircle(this, other);
    }


    public boolean isPointInsideOrOnCircle(Point other, int precision)
    {
        return CircleService.isPointInsideOrOnCircle(this, other, precision);
    }


    public boolean isPointNotOnCircle(Point other)
    {
        return CircleService.isPointNotOnCircle(this, other);
    }


    public boolean isPointNotOnCircle(Point other, int precision)
    {
        return CircleService.isPointNotOnCircle(this, other, precision);
    }


    public ANumber getNumberOfLatticePoints()
    {
        return CircleService.getNumberOfLatticePoints(this);
    }


    public ANumber getNumberOfLatticePoints(int precision)
    {
        return CircleService.getNumberOfLatticePoints(this, precision);
    }


    public ANumber getAngleAsRadiansBetween(Point startPoint, Point endPoint)
    {
        return CircleService.getAngleAsRadiansBetween(this, startPoint, endPoint);
    }


    public ANumber getAngleAsRadiansBetween(Point startPoint, Point endPoint, int precision)
    {
        return CircleService.getAngleAsRadiansBetween(this, startPoint, endPoint, precision);
    }


    public Point getCirclePointBasedOn(Point startPoint, ANumber angle)
    {
        return CircleService.getCirclePointBasedOn(this, startPoint, angle);
    }


    public Point getCirclePointBasedOn(Point startPoint, ANumber angle, int precision)
    {
        return CircleService.getCirclePointBasedOn(this, startPoint, angle, precision);
    }


    public boolean isEquiable()
    {
        return getCircumference().equal(getArea());
    }


    public boolean isLineTangentToCircle(Line line)
    {
        return CircleService.isLineTangentToCircle(this, line);
    }


    public boolean isLineTangentToCircle(Line line, int precision)
    {
        return CircleService.isLineTangentToCircle(this, line, precision);
    }


    public boolean doesLineIntersectCircle(Line line)
    {
        return CircleService.doesLineIntersectCircle(this, line);
    }


    public boolean doesLineIntersectCircle(Line line, int precision)
    {
        return CircleService.doesLineIntersectCircle(this, line, precision);
    }


    public boolean isTangent(Line line)
    {
        return CircleService.isTangent(this, line);
    }


    public boolean isTangent(Line line, int precision)
    {
        return CircleService.isTangent(this, line, precision);
    }


    public boolean isSecant(Line line)
    {
        return CircleService.isSecant(this, line);
    }


    public boolean isSecant(Line line, int precision)
    {
        return CircleService.isSecant(this, line, precision);
    }


    public ANumber getAreaOfMinorSegment(CircleChord chord)
    {
        return CircleService.getAreaOfMinorSegment(this, chord);
    }


    public ANumber getAreaOfMinorSegment(CircleChord chord, int precision)
    {
        return CircleService.getAreaOfMinorSegment(this, chord, precision);
    }


    public ANumber getAreaOfMinorSegment(Point point1, Point point2)
    {
        return CircleService.getAreaOfMinorSegment(this, CircleChord.of(center, radius, point1, point2));
    }


    public ANumber getAreaOfMinorSegment(Point point1, Point point2, int precision)
    {
        return CircleService.getAreaOfMinorSegment(this, CircleChord.of(center, radius, point1, point2), precision);
    }


    public ANumber getAreaOfMajorSegment(CircleChord chord)
    {
        return CircleService.getAreaOfMajorSegment(this, chord);
    }


    public ANumber getAreaOfMajorSegment(CircleChord chord, int precision)
    {
        return CircleService.getAreaOfMajorSegment(this, chord, precision);
    }


    public ANumber getAreaOfMajorSegment(Point point1, Point point2)
    {
        return CircleService.getAreaOfMajorSegment(this, CircleChord.of(center, radius, point1, point2));
    }


    public ANumber getAreaOfMajorSegment(Point point1, Point point2, int precision)
    {
        return CircleService.getAreaOfMajorSegment(this, CircleChord.of(center, radius, point1, point2), precision);
    }


    public CircleSector getSectorFromChord(CircleChord chord)
    {
        CircleChordRules.isValid(chord);
        return getSectorFromPoints(chord.getStartPoint(), chord.getEndPoint());
    }


    public CircleSector getSectorFromPoints(Point point1, Point point2)
    {
        return CircleSector.of(getCenter(), getRadius(), point1, point2);
    }


    public Circle getConcentricCircle(ANumber radius)
    {
        return Circle.of(getCenter(), radius);
    }


    public boolean doCirclesIntersect(Circle other)
    {
        return CircleService.doCirclesIntersect(this, other);
    }


    public Line getTangentLineOnPoint(Point point)
    {
        return CircleService.getTangentLineOnPoint(this, point);
    }


    @Override
    public Circle clone() throws CloneNotSupportedException
    {
        return (Circle)CloningService.clone(this);
    }


    public Circle getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public int hashCode()
    {
        return CircleInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return CircleInternalService.equals(this, object);
    }


    public Point getCenter()
    {
        return this.center;
    }


    public ANumber getRadius()
    {
        return this.radius;
    }


    public Function2x1<ANumber, ANumber, ANumber> getFormula()
    {
        return this.formula;
    }


    public Function2x1<ANumber, ANumber, ANumber> getFormulaPolarForm()
    {
        return this.formulaPolarForm;
    }


    public PolarPoint getCenterPolarPoint()
    {
        return this.centerPolarPoint;
    }
}