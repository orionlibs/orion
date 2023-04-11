package com.orion.math.geometry.shape.circle.arc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class CircleArcTest
{
    @Test
    public void test_circleArc1()
    {
        Point center = Point.of(2, 0);
        Point startPoint = Point.of(3, 0);
        ANumber angleInRadians = ANumber.of("0.78539816339744830961566084581988");
        CircleArc arc = CircleArc.of(center, ANumber.of(1), startPoint, angleInRadians);
        Point resultEndPoint = arc.getEndPoint();
        assertTrue(Point.of(ANumber.of("2.7071067811865478"), ANumber.of("0.7071067811865472")).equals(resultEndPoint));
        angleInRadians = ANumber.of("3.9269908169872415480783042290994");
        arc = CircleArc.of(center, ANumber.of(1), startPoint, angleInRadians);
        resultEndPoint = arc.getEndPoint();
        assertTrue(Point.of(ANumber.of("1.2928932188134526"), ANumber.of("-0.7071067811865477")).equals(resultEndPoint));
    }
}