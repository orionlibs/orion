package com.orion.math.geometry.shape.polygon;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class PolygonServiceTest
{
    @Test
    public void test_isPointInsidePolygon()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 0);
        Point p4 = Point.of(1, 1);
        Polygon polygon = Polygon.of(new Point[]
        {p1, p2, p3, p4});
        boolean result = PolygonService.isPointInsidePolygon(polygon, Point.of(0, 0));
        assertTrue(result);
        result = PolygonService.isPointInsidePolygon(polygon, Point.of(-0.1, 0));
        assertFalse(result);
        result = PolygonService.isPointInsidePolygon(polygon, Point.of(0.5, 1.01));
        assertFalse(result);
        result = PolygonService.isPointInsidePolygon(polygon, Point.of(0.5, 0));
        assertFalse(result);
        result = PolygonService.isPointInsidePolygon(polygon, Point.of(0, 0.9));
        assertTrue(result);
        result = PolygonService.isPointInsidePolygon(polygon, Point.of(0.5, 0.5));
        assertTrue(result);
    }


    @Test
    public void test_getPerimeter()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Polygon polygon = Polygon.of(new Point[]
        {p1, p2, p3, p4});
        ANumber result = PolygonService.getPerimeter(polygon);
        assertTrue(ANumber.of(4).equal(result));
    }


    @Test
    public void test_getArea()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 1);
        Point p4 = Point.of(1, 0);
        Polygon polygon = Polygon.of(new Point[]
        {p1, p2, p3, p4});
        ANumber result = PolygonService.getArea(polygon);
        assertTrue(ANumber.of(1).equal(result));
        p1 = Point.of(-3, -2);
        p2 = Point.of(-1, 4);
        p3 = Point.of(6, 1);
        p4 = Point.of(3, 10);
        Point p5 = Point.of(-4, 9);
        polygon = Polygon.of(new Point[]
        {p1, p2, p3, p4, p5});
        result = PolygonService.getArea(polygon);
        assertTrue(ANumber.of(60).equal(result));
    }
}