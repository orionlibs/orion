package com.orion.math.geometry.shape.rectangle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class RectangleServiceTest
{
    @Test
    public void test_getPerimeter()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Rectangle rectangle = Rectangle.of(p2, p3, p1, p4);
        ANumber result = RectangleService.getPerimeter(rectangle);
        assertTrue(ANumber.of(4).equal(result));
    }


    @Test
    public void test_getArea()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Rectangle rectangle = Rectangle.of(p2, p3, p1, p4);
        ANumber result = RectangleService.getArea(rectangle);
        assertTrue(ANumber.of(1).equal(result));
    }


    @Test
    public void test_isPointInsideRectangle()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Rectangle rectangle = Rectangle.of(p2, p3, p1, p4);
        boolean result = RectangleService.isPointInsideRectangle(rectangle, Point.of(0, 0));
        assertFalse(result);
        result = RectangleService.isPointInsideRectangle(rectangle, Point.of(0.5, 0.5));
        assertTrue(result);
    }


    @Test
    public void test_isPointOnRectangle()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Rectangle rectangle = Rectangle.of(p2, p3, p1, p4);
        boolean result = RectangleService.isPointOnRectangle(rectangle, Point.of(0, 0));
        assertTrue(result);
        result = RectangleService.isPointOnRectangle(rectangle, Point.of(0.5, 0.5));
        assertFalse(result);
    }


    @Test
    public void test_doesOverlapWith()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Rectangle rectangle = Rectangle.of(p2, p3, p1, p4);
        boolean result = RectangleService.doesOverlapWith(rectangle, Rectangle.of(p2, p3, p1, p4));
        assertTrue(result);
        Point p5 = Point.of(ANumber.of("1.00001"), ANumber.of("1"));
        Point p6 = Point.of(ANumber.of("1.00001"), ANumber.of(0));
        result = RectangleService.doesOverlapWith(rectangle, Rectangle.of(p2, p5, p1, p6));
        assertTrue(result);
        p5 = Point.of(ANumber.of("1.00001"), ANumber.of("0"));
        p6 = Point.of(ANumber.of("1.00002"), ANumber.of("0"));
        Point p7 = Point.of(ANumber.of("1.00001"), ANumber.of("1"));
        Point p8 = Point.of(ANumber.of("1.00002"), ANumber.of("1"));
        rectangle = Rectangle.of(p2, p3, p1, p4);
        result = RectangleService.doesOverlapWith(rectangle, Rectangle.of(p5, p6, p7, p8));
        assertFalse(result);
    }


    @Test
    public void test_doLineSegmentsFormRectangle()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        LineSegment ls1 = LineSegment.of(p1, p2);
        LineSegment ls2 = LineSegment.of(p2, p3);
        LineSegment ls3 = LineSegment.of(p3, p4);
        LineSegment ls4 = LineSegment.of(p4, p1);
        boolean result = RectangleService.doLineSegmentsFormRectangle(ls1, ls2, ls3, ls4);
        assertTrue(result);
        p4 = Point.of(1, 0.0001);
        ls3 = LineSegment.of(p3, p4);
        ls4 = LineSegment.of(p4, p1);
        result = RectangleService.doLineSegmentsFormRectangle(ls1, ls2, ls3, ls4);
        assertFalse(result);
        p1 = Point.of(-1, 1);
        p2 = Point.of(0, 0);
        p3 = Point.of(1, 1);
        p4 = Point.of(0, 2);
        ls1 = LineSegment.of(p1, p2);
        ls2 = LineSegment.of(p2, p3);
        ls3 = LineSegment.of(p3, p4);
        ls4 = LineSegment.of(p4, p1);
        result = RectangleService.doLineSegmentsFormRectangle(ls1, ls2, ls3, ls4);
        assertTrue(result);
    }


    @Test
    public void test_getLengthOfDiagonal()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Rectangle rectangle = Rectangle.of(p2, p3, p1, p4);
        ANumber result = RectangleService.getLengthOfDiagonal(rectangle);
        assertTrue(ANumber.of("1.4142135623730951").equal(result));
    }


    @Test
    public void test_getLeftDiagonal()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Rectangle rectangle = Rectangle.of(p2, p3, p1, p4);
        LineSegment result = RectangleService.getLeftDiagonal(rectangle);
        assertTrue(LineSegment.of(p2, p4).equals(result));
    }


    @Test
    public void test_getRightDiagonal()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Rectangle rectangle = Rectangle.of(p2, p3, p1, p4);
        LineSegment result = RectangleService.getRightDiagonal(rectangle);
        assertTrue(LineSegment.of(p1, p3).equals(result));
    }
}