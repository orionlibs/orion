package com.orion.math.geometry.point;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.geometry.Orientation;
import com.orion.math.geometry.plane.Plane;
import com.orion.math.geometry.point.polar.PolarPoint;
import com.orion.math.geometry.point.polar.PolarPointRules;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import com.orion.math.streams.NumberArrayStream;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Point implements MathObject, Cloneable
{
    private ANumber[] coordinates;


    public Point(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        this.coordinates = new ANumber[]
        {x, y};
    }


    public Point(ANumber x, ANumber y, ANumber z)
    {
        NumberRules.areNotNull(x, y, z);
        this.coordinates = new ANumber[]
        {x, y, z};
    }


    public Point(Number x, Number y)
    {
        NumberRules.areNotNull(x, y);
        this.coordinates = new ANumber[]
        {ANumber.of(x), ANumber.of(y)};
    }


    public Point(Number x, Number y, Number z)
    {
        NumberRules.areNotNull(x, y, z);
        this.coordinates = new ANumber[]
        {ANumber.of(x), ANumber.of(y), ANumber.of(z)};
    }


    public Point(ANumber[] coordinates)
    {
        PointRules.isValid(coordinates);
        this.coordinates = coordinates;
    }


    public Point(int dimensions)
    {
        PointRules.isValid(dimensions);
        ANumber[] pointCoordinates = new ANumber[dimensions];
        NumberArrayStream.setZeroValue(pointCoordinates);
        this.coordinates = pointCoordinates;
    }


    public static Point of(ANumber x, ANumber y)
    {
        return new Point(x, y);
    }


    public static Point of(ANumber x, ANumber y, ANumber z)
    {
        return new Point(x, y, z);
    }


    public static Point of(Number x, Number y)
    {
        return new Point(x, y);
    }


    public static Point of(Number x, Number y, Number z)
    {
        return new Point(x, y, z);
    }


    public static Point of(ANumber[] coordinates)
    {
        return new Point(coordinates);
    }


    public static Point of(int dimensions)
    {
        return new Point(dimensions);
    }


    public static Point ofZeroPoint()
    {
        return new Point(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(0)});
    }


    public static Point ofZeroPoint(int dimensions)
    {
        PointRules.isValid(dimensions);
        ANumber[] newCoordinates = new ANumber[dimensions];
        NumberArrayStream.setZeroValue(newCoordinates);
        return Point.of(newCoordinates);
    }


    public PolarPoint getAsPolarPoint()
    {
        PolarPointRules.isValidDimensionsForPolarCoordinates(getDimensions());
        return PolarPoint.of(getDistanceFromOrigin(), getAngleFromXAxis());
    }


    public PolarPoint getAsPolarPoint(int precision)
    {
        PolarPointRules.isValidDimensionsForPolarCoordinates(getDimensions());
        ANumber angle = getAngleFromXAxis(precision);

        if(angle.isNaN())
        {
            angle = ANumber.of(0);
        }

        return PolarPoint.of(getDistanceFromOrigin(precision), getAngleFromXAxis(precision));
    }


    public ANumber get(int index)
    {
        return getCoordinates()[index];
    }


    public void set(int index, ANumber element)
    {
        getCoordinates()[index] = element;
    }


    public ANumber getDistanceFromOrigin()
    {
        return getDistanceFromOrigin(Precision.precision);
    }


    public ANumber getDistanceFromOrigin(int precision)
    {
        precision = Precision.getValidPrecision(precision);
        ANumber distance = ANumber.of(0);
        Arrays.stream(coordinates).forEach(c -> distance.add(c.squareGET()));
        return distance.getSquareRoot(precision);
    }


    public ANumber getDistanceFromPoint(Point other)
    {
        return getDistanceFromPoint(other, Precision.precision);
    }


    public ANumber getDistanceFromPoint(Point other, int precision)
    {
        PointRules.doDimensionsMatch(this, other);
        precision = Precision.getValidPrecision(precision);
        return getDistanceSquaredFromPoint(other).getSquareRoot(precision);
    }


    public ANumber getDistanceSquaredFromPoint(Point other)
    {
        PointRules.doDimensionsMatch(this, other);
        ANumber distance = ANumber.of(0);
        IntStream.range(0, getDimensions())
                        .forEach(i -> distance.add(coordinates[i].subtractGET(other.getCoordinates()[i]).squareGET()));
        return distance;
    }


    public ANumber getAngleFromXAxis()
    {
        return getAngleFromXAxis(Precision.precision);
    }


    public ANumber getAngleFromXAxis(int precision)
    {
        Vector vector = Vector.of(getCoordinates());
        return vector.getAngleWithXAxisAsRadians(precision);
    }


    public Orientation getOrientation(Point q, Point r)
    {
        return PointService.getOrientation(this, q, r);
    }


    public ANumber getNumberOfLatticePointsBetween(Point other)
    {
        return PointService.getNumberOfLatticePointsBetween(this, other);
    }


    public ANumber getNumberOfIntegralPointsBetween(Point other)
    {
        return PointService.getNumberOfIntegralPointsBetween(this, other);
    }


    public Point reflectAboutALineSegment(LineSegment lineSegment)
    {
        return PointService.reflectAboutALineSegment(this, lineSegment);
    }


    public Point reflectAboutALine(Line line)
    {
        return PointService.reflectAboutALine(this, line);
    }


    public Point reflectAboutAPlane(Plane plane)
    {
        return PointService.reflectAboutAPlane(this, plane);
    }


    public ANumber getDistanceFromLine(Line line)
    {
        return PointService.getDistanceFromLine(this, line);
    }


    public ANumber getDistanceFromLine(Line line, int precision)
    {
        return PointService.getDistanceFromLine(this, line, precision);
    }


    public Point translate(ANumber x)
    {
        return PointService.translate(this, x);
    }


    public boolean doesPointLieOnTheLeftOfLineSegment(LineSegment lineSegment)
    {
        return PointService.doesPointLieOnTheLeftOfLineSegment(this, lineSegment);
    }


    public boolean doesPointLieOnTheRightOfLineSegment(LineSegment lineSegment)
    {
        return PointService.doesPointLieOnTheRightOfLineSegment(this, lineSegment);
    }


    public int getDimensions()
    {
        return coordinates.length;
    }


    public ANumber getX()
    {
        return (getDimensions() == 0) ? null : coordinates[0];
    }


    public ANumber getY()
    {
        return (getDimensions() <= 1) ? null : coordinates[1];
    }


    public ANumber getZ()
    {
        return (getDimensions() <= 2) ? null : coordinates[2];
    }


    public ANumber[] getCoordinatesCopy()
    {
        ANumber[] newCoordinates = new ANumber[getDimensions()];
        IntStream.range(0, getCoordinates().length).forEach(i -> newCoordinates[i] = getCoordinates()[i].getCopy());
        return newCoordinates;
    }


    @Override
    public String toString()
    {
        return print();
    }


    public String print()
    {
        return PointService.print(this);
    }


    @Override
    public int hashCode()
    {
        return PointInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return PointInternalService.equals(this, object);
    }


    @Override
    public Point clone() throws CloneNotSupportedException
    {
        return (Point)CloningService.clone(this);
    }


    public Point getCopy()
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


    public ANumber[] getCoordinates()
    {
        return this.coordinates;
    }
}