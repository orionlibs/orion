package com.orion.math.geometry.shape.ellipse;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentService;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class Ellipse implements MathObject, Cloneable
{
    private Point focalPoint1;
    private Point focalPoint2;
    private ANumber radiusOfMinorAxis;
    private ANumber radiusOfMajorAxis;
    private Point center;
    private Line majorAxisLine;
    private Line minorAxisLine;
    private ANumber focalDistance;
    private ANumber eccentricity;
    private ANumber slopeOfFocalPointsLineSegment;
    private Point majorAxisLeftVertex;
    private Point majorAxisRightVertex;
    private Point minorAxisTopCovertex;
    private Point minorAxisBottomCovertex;
    private Function2x1<ANumber, ANumber, ANumber> formula;


    public Ellipse(Point focalPoint1, Point focalPoint2, ANumber radiusOfMinorAxis, ANumber radiusOfMajorAxis)
    {
        this(focalPoint1, focalPoint2, radiusOfMinorAxis, radiusOfMajorAxis, Precision.precision);
    }


    public Ellipse(Point focalPoint1, Point focalPoint2, ANumber radiusOfMinorAxis, ANumber radiusOfMajorAxis, int precision)
    {
        EllipseRules.isValid(focalPoint1, focalPoint2, radiusOfMinorAxis, radiusOfMajorAxis);
        this.focalPoint1 = focalPoint1;
        this.focalPoint2 = focalPoint2;
        this.radiusOfMinorAxis = radiusOfMinorAxis;
        this.radiusOfMajorAxis = radiusOfMajorAxis;
        LineSegment focalPointsLineSegment = LineSegment.of(focalPoint1, focalPoint2);
        this.slopeOfFocalPointsLineSegment = focalPointsLineSegment.getLine().getSlope();
        this.center = focalPointsLineSegment.getMidpoint();
        this.majorAxisLine = focalPointsLineSegment.getLine();
        this.minorAxisLine = LineSegmentService.getPerpendicularBisector(LineSegment.of(focalPoint1, focalPoint2));
        this.focalDistance = LineSegment.of(focalPoint1, center).getLength(precision);
        this.eccentricity = focalDistance.divideGET(radiusOfMajorAxis);

        if(focalPointsLineSegment.isParallelToXAxis())
        {
            this.majorAxisLeftVertex = Point.of(center.getX().subtractGET(radiusOfMajorAxis), center.getY());
            ;
            this.majorAxisRightVertex = Point.of(center.getX().addGET(radiusOfMajorAxis), center.getY());
            this.minorAxisTopCovertex = Point.of(center.getX(), center.getY().addGET(radiusOfMinorAxis));
            this.minorAxisBottomCovertex = Point.of(center.getX(), center.getY().subtractGET(radiusOfMinorAxis));
        }

        buildFormula();
    }


    public static Ellipse of(Point focalPoint1, Point focalPoint2, ANumber radiusOfMinorAxis, ANumber radiusOfMajorAxis)
    {
        return new Ellipse(focalPoint1, focalPoint2, radiusOfMinorAxis, radiusOfMajorAxis);
    }


    public static Ellipse of(Point focalPoint1, Point focalPoint2, ANumber radiusOfMinorAxis, ANumber radiusOfMajorAxis, int precision)
    {
        return new Ellipse(focalPoint1, focalPoint2, radiusOfMinorAxis, radiusOfMajorAxis, precision);
    }


    private void buildFormula()
    {
        ANumber slopeSquaredPlus1 = slopeOfFocalPointsLineSegment.squareGET().addOneGET();
        ANumber aSquared = radiusOfMajorAxis.squareGET().multiplyGET(slopeSquaredPlus1);
        ANumber bSquared = radiusOfMinorAxis.squareGET().multiplyGET(slopeSquaredPlus1);
        Function2x1IF<ANumber, ANumber, ANumber> formulaFunction = (ANumber x, ANumber y) ->
        {
            ANumber yMinusCenterY = y.subtractGET(center.getY());
            ANumber xMinusCenterX = x.subtractGET(center.getX());
            ANumber firstPart = slopeOfFocalPointsLineSegment.multiplyGET(yMinusCenterY).addGET(xMinusCenterX).squareGET().divideGET(aSquared);
            ANumber secondPart = yMinusCenterY.subtractGET(slopeOfFocalPointsLineSegment.multiplyGET(xMinusCenterX)).squareGET().divideGET(bSquared);
            return firstPart.addGET(secondPart).subtractOneGET();
        };
        formula = new Function2x1<ANumber, ANumber, ANumber>(formulaFunction);
    }


    public boolean isMajorAxisParallelToXAxis()
    {
        return EllipseService.isMajorAxisParallelToXAxis(this);
    }


    public ANumber getArea()
    {
        return EllipseService.getArea(this);
    }


    public ANumber getCircumference()
    {
        return EllipseService.getCircumference(this);
    }


    public ANumber getCircumference(int precision)
    {
        return EllipseService.getCircumference(this, precision);
    }


    @Override
    public Ellipse clone() throws CloneNotSupportedException
    {
        return (Ellipse)CloningService.clone(this);
    }


    public Ellipse getCopy()
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
        return EllipseInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return EllipseInternalService.equals(this, object);
    }


    public Function2x1<ANumber, ANumber, ANumber> getFormula()
    {
        return this.formula;
    }


    public Point getFocalPoint1()
    {
        return this.focalPoint1;
    }


    public Point getFocalPoint2()
    {
        return this.focalPoint2;
    }


    public ANumber getRadiusOfMajorAxis()
    {
        return this.radiusOfMajorAxis;
    }


    public Point getCenter()
    {
        return this.center;
    }


    public Line getMajorAxisLine()
    {
        return this.majorAxisLine;
    }


    public Line getMinorAxisLine()
    {
        return this.minorAxisLine;
    }


    public ANumber getFocalDistance()
    {
        return this.focalDistance;
    }


    public ANumber getEccentricity()
    {
        return this.eccentricity;
    }


    public ANumber getSlopeOfFocalPointsLineSegment()
    {
        return this.slopeOfFocalPointsLineSegment;
    }


    public ANumber getRadiusOfMinorAxis()
    {
        return this.radiusOfMinorAxis;
    }


    public Point getMajorAxisLeftVertex()
    {
        return this.majorAxisLeftVertex;
    }


    public Point getMajorAxisRightVertex()
    {
        return this.majorAxisRightVertex;
    }


    public Point getMinorAxisTopCovertex()
    {
        return this.minorAxisTopCovertex;
    }


    public Point getMinorAxisBottomCovertex()
    {
        return this.minorAxisBottomCovertex;
    }
}