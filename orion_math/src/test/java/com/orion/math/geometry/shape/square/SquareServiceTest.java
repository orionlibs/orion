package com.orion.math.geometry.shape.square;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class SquareServiceTest
{
    @Test
    public void test_getPerimeter()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Square square = Square.of(p2, p3, p1, p4);
        ANumber result = SquareService.getPerimeter(square);
        assertTrue(ANumber.of(4).equal(result));
    }


    @Test
    public void test_getArea()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Square square = Square.of(p2, p3, p1, p4);
        ANumber result = SquareService.getArea(square);
        assertTrue(ANumber.of(1).equal(result));
    }


    @Test
    public void test_isPointInsideSquare()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Square square = Square.of(p2, p3, p1, p4);
        boolean result = SquareService.isPointInsideSquare(square, Point.of(0, 0));
        assertFalse(result);
        result = SquareService.isPointInsideSquare(square, Point.of(0.5, 0.5));
        assertTrue(result);
    }


    @Test
    public void test_isPointOnSquare()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Square square = Square.of(p2, p3, p1, p4);
        boolean result = SquareService.isPointOnSquare(square, Point.of(0, 0));
        assertTrue(result);
        result = SquareService.isPointOnSquare(square, Point.of(0.5, 0.5));
        assertFalse(result);
    }


    @Test
    public void test_doLineSegmentsFormSquare()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        LineSegment ls1 = LineSegment.of(p1, p2);
        LineSegment ls2 = LineSegment.of(p2, p3);
        LineSegment ls3 = LineSegment.of(p3, p4);
        LineSegment ls4 = LineSegment.of(p4, p1);
        boolean result = SquareService.doLineSegmentsFormSquare(ls1, ls2, ls3, ls4);
        assertTrue(result);
        p4 = Point.of(1, 0.0001);
        ls3 = LineSegment.of(p3, p4);
        ls4 = LineSegment.of(p4, p1);
        result = SquareService.doLineSegmentsFormSquare(ls1, ls2, ls3, ls4);
        assertFalse(result);
        p1 = Point.of(-1, 1);
        p2 = Point.of(0, 0);
        p3 = Point.of(1, 1);
        p4 = Point.of(0, 2);
        ls1 = LineSegment.of(p1, p2);
        ls2 = LineSegment.of(p2, p3);
        ls3 = LineSegment.of(p3, p4);
        ls4 = LineSegment.of(p4, p1);
        result = SquareService.doLineSegmentsFormSquare(ls1, ls2, ls3, ls4);
        assertTrue(result);
    }
}