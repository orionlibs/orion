package com.orion.math.geometry.shape.ellipse;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class EllipseTest
{
    @Test
    public void test_circleArc1()
    {
        Point focalPoint1 = Point.of(ANumber.of(0), ANumber.of(5).getSquareRoot());
        Point focalPoint2 = Point.of(ANumber.of(0), ANumber.of(5).getSquareRoot().negateGET());
        Ellipse ellipse = Ellipse.of(focalPoint1, focalPoint2, ANumber.of(5), ANumber.of(6));
        assertTrue(Point.of(0, 0).equals(ellipse.getCenter()));
    }
}