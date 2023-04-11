package com.orion.math.geometry.shape.polygon;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.object.CloningService;
import com.orion.core.stream.OrionStream;
import com.orion.math.MathObject;
import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Polygon implements MathObject, Cloneable
{
    private OrionList<Point> points;


    /**
     * The sides of the polygon will be constructed based on the order the points
     * are provided e.g. for point1, point2 and point3 the sides will be (point1,
     * point2), (point2, point3) and (point3, point1)
     * @param points
     */
    public Polygon(OrionList<Point> points)
    {
        PolygonRules.isValid(points);
        this.points = points;
    }


    /**
     * The sides of the polygon will be constructed based on the order the points
     * are provided e.g. for point1, point2 and point3 the sides will be (point1,
     * point2), (point2, point3) and (point3, point1)
     * @param points
     */
    public Polygon(Point[] points)
    {
        PolygonRules.isValid(points);
        this.points = OrionArrayList.of(points);
    }


    /**
     * The sides of the polygon will be constructed based on the order the points
     * are provided e.g. for point1, point2 and point3 the sides will be (point1,
     * point2), (point2, point3) and (point3, point1)
     * @param points
     */
    public static Polygon of(OrionList<Point> points)
    {
        return new Polygon(points);
    }


    /**
     * The sides of the polygon will be constructed based on the order the points
     * are provided e.g. for point1, point2 and point3 the sides will be (point1,
     * point2), (point2, point3) and (point3, point1)
     * @param points
     */
    public static Polygon of(Point[] points)
    {
        return new Polygon(points);
    }


    public boolean isPointInsidePolygon(Point point)
    {
        return PolygonService.isPointInsidePolygon(this, point);
    }


    public Point get(int index)
    {
        return getPoints().get(index);
    }


    public ANumber getMinimumCostOfTriangulation()
    {
        return PolygonService.getMinimumCostOfTriangulation(this);
    }


    public ANumber getMinimumCostOfTriangulation(int precision)
    {
        return PolygonService.getMinimumCostOfTriangulation(this, precision);
    }


    public int getNumberOfVertices()
    {
        return points.getSize();
    }


    public ANumber getPerimeter()
    {
        return PolygonService.getPerimeter(this);
    }


    public ANumber getArea()
    {
        return PolygonService.getArea(this);
    }


    public Point[] getPointsAsArray()
    {
        return points.getAsArray();
    }


    public Stream<Point> filter(Predicate<Point> filterToApply)
    {
        return getPoints().filter(filterToApply);
    }


    public boolean findAny(Predicate<Point> filterToApply)
    {
        return getPoints().findAny(filterToApply);
    }


    public boolean findAny(IntPredicate filterToApply)
    {
        return OrionStream.findAny(getPoints().getAsArray(), filterToApply);
    }


    public void forAll(Consumer<Point> action)
    {
        getPoints().forAll(action);
    }


    public void forAllIndices(IntConsumer action)
    {
        OrionStream.forAllIndices(getPoints().getAsArray(), action);
    }


    public void forAll(Stream<Point> stream, Consumer<Point> action)
    {
        getPoints().forAll(stream, action);
    }


    public void forAllIndices(IntStream stream, IntConsumer action)
    {
        OrionStream.forAll(stream, action);
    }


    public void filterAndLoop(Predicate<Point> filterToApply, Consumer<Point> action)
    {
        forAll(filter(filterToApply), action);
    }


    public void filterAndLoopIndices(IntPredicate filterToApply, IntConsumer action)
    {
        OrionStream.filterAndLoop(getPoints().getAsArray(), filterToApply, action);
    }


    @Override
    public Polygon clone() throws CloneNotSupportedException
    {
        return (Polygon)CloningService.clone(this);
    }


    public Polygon getCopy()
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
        return PolygonInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return PolygonInternalService.equals(this, object);
    }


    public OrionList<Point> getPoints()
    {
        return this.points;
    }
}