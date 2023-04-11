package com.orion.math.interpolation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.spline.PolynomialSpline;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class InterpolationServiceTest
{
    @Test
    public void testDoPolynomialInterpolation()
    {
        Vector xValues = Vector.of(1, 2, 3, 3.4);
        Vector yValues = Vector.of(1.1, 2.1, 5, 7);
        Polynomial result = InterpolationService.doPolynomialInterpolation(xValues, yValues);
        ANumber expected = ANumber.of("3.226752443440969306670823984172537116450068398899995");
        assertTrue(result.getValueFor(ANumber.of(2.5)).equal(expected));
    }


    @Test
    public void testDoLagrangeInterpolation()
    {
        Vector xValues = Vector.of(1, 2, 3, 3.4);
        Vector yValues = Vector.of(1.1, 2.1, 5, 7);
        Polynomial result = InterpolationService.doLagrangeInterpolation(xValues, yValues);
        ANumber expected = ANumber.of(3.3125);
        assertTrue(result.getValueFor(ANumber.of(2.5)).equal(expected));
    }


    @Test
    public void testDoBicubicSplineInterpolation()
    {
        Vector xValues = Vector.of(1, 2, 3, 3.4);
        Vector yValues = Vector.of(1.1, 2.1, 5, 7);
        PolynomialSpline result = InterpolationService.doBicubicSplineInterpolation(xValues, yValues);
        ANumber expected = ANumber.of(3.24375);
        assertTrue(result.getValueFor(ANumber.of(2.5)).equal(expected));
    }
}