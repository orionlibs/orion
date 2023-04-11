package com.orion.math.geometry.point;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.geometry.Orientation;
import com.orion.math.geometry.plane.Plane;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class PointServiceTest
{
    @Test
    public void test_areCollinear()
    {
        Point p1 = Point.of(2, 4);
        Point p2 = Point.of(2, 7);
        boolean result = PointService.areCollinear(p1, p2);
        assertFalse(result);
        p2 = Point.of(4, 6);
        Point p3 = Point.of(6, 8);
        result = PointService.areCollinear(p1, p2, p3);
        assertTrue(result);
        p1 = Point.of(1, -2, 3);
        p2 = Point.of(2, -3, 5);
        p3 = Point.of(1, 1, 0);
        result = PointService.areCollinear(p1, p2, p3);
        assertFalse(result);
        p1 = Point.of(5, 4, 2);
        p2 = Point.of(6, 2, -1);
        p3 = Point.of(8, -2, -7);
        result = PointService.areCollinear(p1, p2, p3);
        assertTrue(result);
        p1 = Point.of(2, 3, 4);
        p2 = Point.of(-1, -2, 1);
        p3 = Point.of(5, 8, 7);
        result = PointService.areCollinear(10, p1, p2, p3);
        assertTrue(result);
        p1 = Point.of(-1, 0, 2);
        p2 = Point.of(1, 1, 4);
        p3 = Point.of(3, 2, 6);
        result = PointService.areCollinear(10, p1, p2, p3);
        assertTrue(result);
    }


    @Test
    public void test_areCoplanar()
    {
        Point p1 = Point.of(1, 2, 3);
        Point p2 = Point.of(4, 7, 8);
        Point p3 = Point.of(3, 5, 5);
        Point p4 = Point.of(-1, -2, -3);
        Point p5 = Point.of(2, 2, 2);
        boolean result = PointService.areCoplanar(p1, p2, p3, p4, p5);
        assertFalse(result);
        p1 = Point.of(0, 0, 1);
        p2 = Point.of(0, 1, 2);
        p3 = Point.of(-2, 1, 3);
        p4 = Point.of(4, 3, 2);
        result = PointService.areCoplanar(p1, p2, p3, p4);
        assertTrue(result);
        p1 = Point.of(-1, 0, 1);
        p2 = Point.of(0, 1, 2);
        p3 = Point.of(1, 2, 3);
        p4 = Point.of(7, 2, 1);
        result = PointService.areCoplanar(p1, p2, p3, p4);
        assertTrue(result);
        p1 = Point.of(4, -3, 2);
        p2 = Point.of(11, -8, 5);
        p3 = Point.of(-3, 2, 1);
        p4 = Point.of(1, 3, 2);
        result = PointService.areCoplanar(p1, p2, p3, p4);
        assertFalse(result);
        p1 = Point.of(4, -3, 22);
        p2 = Point.of(113, -87, 59);
        p3 = Point.of(-3, 25, 1);
        result = PointService.areCoplanar(p1, p2, p3);
        assertTrue(result);
    }


    @Test
    public void test_getDistanceOfClosestPairOfPoints()
    {
        Point p1 = Point.of(2, 3);
        Point p2 = Point.of(12, 30);
        Point p3 = Point.of(40, 50);
        Point p4 = Point.of(5, 1);
        Point p5 = Point.of(12, 10);
        Point p6 = Point.of(3, 4);
        Point[] points = new Point[]
        {p1, p2, p3, p4, p5, p6};
        ANumber result = PointService.getDistanceOfClosestPairOfPoints(points);
        assertTrue(ANumber.of("1.4142135623730951").equal(result));
    }


    @Test
    public void test_getHammeredDistanceBetweenPoints()
    {
        Point p1 = Point.of(0, 1);
        Point p2 = Point.of(0, 0);
        Point p3 = Point.of(1, 0);
        ANumber result = PointService.getHammeredDistanceBetweenPoints(p1, p2, p3);
        assertTrue(ANumber.of(4).equal(result));
        p1 = Point.of(1, 0);
        p2 = Point.of(2, 0);
        p3 = Point.of(3, 0);
        Point p4 = Point.of(4, 0);
        result = PointService.getHammeredDistanceBetweenPoints(p1, p2, p3, p4);
        assertTrue(ANumber.of(20).equal(result));
    }


    @Test
    public void test_getNumberOfLatticePointsBetweenIncludingGivenPoints()
    {
        Point p1 = Point.of(3, 3);
        Point p2 = Point.of(-1, -1);
        ANumber result = PointService.getNumberOfLatticePointsBetweenIncludingGivenPoints(p1, p2);
        assertTrue(ANumber.of(5).equal(result));
        p1 = Point.of(-9, -2);
        p2 = Point.of(6, 8);
        result = PointService.getNumberOfLatticePointsBetweenIncludingGivenPoints(p1, p2);
        assertTrue(ANumber.of(6).equal(result));
        p1 = Point.of(1, 9);
        p2 = Point.of(8, 16);
        result = PointService.getNumberOfLatticePointsBetweenIncludingGivenPoints(p1, p2);
        assertTrue(ANumber.of(8).equal(result));
        p1 = Point.of(0, 2);
        p2 = Point.of(4, 0);
        result = PointService.getNumberOfLatticePointsBetweenIncludingGivenPoints(p1, p2);
        assertTrue(ANumber.of(3).equal(result));
    }


    @Test
    public void test_getOrientation()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(4, 4);
        Point p3 = Point.of(1, 2);
        Orientation result = PointService.getOrientation(p1, p2, p3);
        assertTrue(Orientation.Counterclockwise.is(result));
        p1 = Point.of(0, 0);
        p2 = Point.of(4, 4);
        p3 = Point.of(1, 1);
        result = PointService.getOrientation(p1, p2, p3);
        assertTrue(Orientation.Collinear.is(result));
    }


    @Test
    public void test_reflectAboutAPlane()
    {
        Point p1 = Point.of(-1, 3, 4);
        Plane plane = Plane.of(1, -2, 0, 0);
        Point result = PointService.reflectAboutAPlane(p1, plane);
        assertTrue(Point.of(1.8, -2.6, 4).equals(result));
    }


    @Test
    public void test_reflectAboutALine()
    {
        Point p1 = Point.of(1, 1);
        Line line = Line.of(0, 1, 0);
        Point result = PointService.reflectAboutALine(p1, line);
        assertTrue(Point.of(-1, 1).equals(result));
    }


    @Test
    public void test_translate()
    {
        Point p1 = Point.of(1, 1);
        Point result = PointService.translate(p1, ANumber.of(6));
        assertTrue(Point.of(7, 7).equals(result));
    }


    @Test
    public void test_getDistanceFromLine()
    {
        Point p1 = Point.of(5, 6);
        Line line = Line.of(-2, 3, 4);
        ANumber result = PointService.getDistanceFromLine(p1, line);
        assertTrue(ANumber.of("3.328201177351375").equals(result));
    }


    @Test
    public void test_doesPointLieOnTheLeftOfLineSegment()
    {
        Point p1 = Point.of(-1, 0);
        LineSegment line = LineSegment.of(Point.of(0, 0), Point.of(0, 1));
        boolean result = PointService.doesPointLieOnTheLeftOfLineSegment(p1, line);
        assertTrue(result);
        p1 = Point.of(-7, -7);
        result = PointService.doesPointLieOnTheLeftOfLineSegment(p1, line);
        assertTrue(result);
        p1 = Point.of(7, 7);
        result = PointService.doesPointLieOnTheLeftOfLineSegment(p1, line);
        assertFalse(result);
        p1 = Point.of(7, 1);
        result = PointService.doesPointLieOnTheLeftOfLineSegment(p1, line);
        assertFalse(result);
    }


    @Test
    public void test_doesPointLieOnTheRightOfLineSegment()
    {
        Point p1 = Point.of(1, 0);
        LineSegment line = LineSegment.of(Point.of(0, 0), Point.of(0, 1));
        boolean result = PointService.doesPointLieOnTheRightOfLineSegment(p1, line);
        assertTrue(result);
        p1 = Point.of(7, -7);
        result = PointService.doesPointLieOnTheRightOfLineSegment(p1, line);
        assertTrue(result);
        p1 = Point.of(-7, 7);
        result = PointService.doesPointLieOnTheRightOfLineSegment(p1, line);
        assertFalse(result);
        p1 = Point.of(-7, 1);
        result = PointService.doesPointLieOnTheRightOfLineSegment(p1, line);
        assertFalse(result);
    }
}