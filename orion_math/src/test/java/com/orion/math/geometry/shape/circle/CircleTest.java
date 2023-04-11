package com.orion.math.geometry.shape.circle;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class CircleTest
{
    @Test
    public void test_circle()
    {
        Point p1 = Point.of(1, 0);
        Point p2 = Point.of(-1, 0);
        Point p3 = Point.of(0, 1);
        Circle circle = Circle.of(p1, p2, p3);
        Point resultCenter = circle.getCenter();
        ANumber resultRadius = circle.getRadius();
        assertTrue(Point.of(0, 0).equals(resultCenter));
        assertTrue(ANumber.of(1).equals(resultRadius));
        p1 = Point.of(1, -6);
        p2 = Point.of(2, 1);
        p3 = Point.of(5, 2);
        circle = Circle.of(p1, p2, p3);
        resultCenter = circle.getCenter();
        resultRadius = circle.getRadius();
        assertTrue(Point.of(ANumber.of("5.000800000000000040006"), ANumber.of("-3.00040000000000002000320000000000016")).equals(resultCenter));
        assertTrue(ANumber.of("5.00040006399488").equals(resultRadius));
    }
}