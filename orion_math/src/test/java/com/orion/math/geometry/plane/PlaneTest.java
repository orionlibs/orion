package com.orion.math.geometry.plane;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class PlaneTest
{
    @Test
    public void testAdd1()
    {
        Plane p1 = Plane.of(ANumber.of(2), ANumber.of(4), ANumber.of(-2), ANumber.of(-5));
        Plane p2 = Plane.of(ANumber.of(6), ANumber.of(-8), ANumber.of(-2), ANumber.of(-14));
        ANumber result = PlaneService.getAngleWithPlane(p1, p2);
        ANumber expected = ANumber.of("1.244796294241247");
        assertTrue(expected.equal(result));
    }
}