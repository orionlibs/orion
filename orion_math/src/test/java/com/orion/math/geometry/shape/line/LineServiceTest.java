package com.orion.math.geometry.shape.line;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class LineServiceTest
{
    @Test
    public void test_getDistanceFromPoint()
    {
        Line line = Line.of(2, 5, 10);
        ANumber result = LineService.getDistanceFromPoint(line, Point.of(2, 3));
        assertTrue(ANumber.of("5.3851648071345041").equal(result));
    }


    @Test
    public void test_doesIntersect()
    {
        Line line1 = Line.of(2, 5, 10);
        Line line2 = Line.of(2, 5, -10);
        boolean result = LineService.doesIntersect(line1, line2);
        assertFalse(result);
        line2 = Line.of(2, 3, 10);
        result = LineService.doesIntersect(line1, line2);
        assertTrue(result);
    }


    @Test
    public void test_getIntersectionPoint()
    {
        Line line1 = Line.of(2, 5, 10);
        Line line2 = Line.of(2, 5, -10);
        Point result = LineService.getIntersectionPoint(line1, line2);
        assertTrue(result == null);
        line1 = Line.of(-1, 1, 0);
        line2 = Line.ofParallelToYAxis(6);
        result = LineService.getIntersectionPoint(line1, line2);
        assertTrue(Point.of(6, 6).equals(result));
        line2 = Line.ofParallelToXAxis(6);
        result = LineService.getIntersectionPoint(line1, line2);
        assertTrue(Point.of(6, 6).equals(result));
    }


    @Test
    public void test_getLineThatBestFitsPoints()
    {
        Point p1 = Point.of(0, 2);
        Point p2 = Point.of(1, 2.1);
        Point p3 = Point.of(2, 1.9);
        Point p4 = Point.of(3, 1.8);
        Line result = LineService.getLineThatBestFitsPoints(p1, p2, p3, p4);
        assertTrue(Line.of(-0.08, 2.07).equals(result));
    }
}