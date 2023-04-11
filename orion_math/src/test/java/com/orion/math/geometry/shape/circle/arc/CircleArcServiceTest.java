package com.orion.math.geometry.shape.circle.arc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class CircleArcServiceTest
{
    @Test
    public void test_getLength()
    {
        Point center = Point.of(2, 0);
        Point startPoint = Point.of(3, 0);
        ANumber angleInRadians = ANumber.of("0.78539816339744830961566084581988");
        CircleArc arc = CircleArc.of(center, ANumber.of(1), startPoint, angleInRadians);
        ANumber result = CircleArcService.getLength(arc);
        assertTrue(ANumber.of("0.78539816339744830961566084581988").equal(result));
        angleInRadians = ANumber.of("3.9269908169872415480783042290994");
        arc = CircleArc.of(center, ANumber.of(1), startPoint, angleInRadians);
        result = arc.getLength();
        assertTrue(ANumber.of("3.9269908169872415480783042290994").equal(result));
    }


    @Test
    public void test_getAreaFormedByArc()
    {
        Point center = Point.of(2, 0);
        Point startPoint = Point.of(3, 0);
        ANumber angleInRadians = ANumber.of("0.78539816339744830961566084581988");
        CircleArc arc = CircleArc.of(center, ANumber.of(1), startPoint, angleInRadians);
        ANumber result = CircleArcService.getAreaFormedByArc(arc);
        assertTrue(ANumber.of("0.39269908169872415480783042290994").equal(result));
    }
}