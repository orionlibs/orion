package com.orion.math.geometry.shape.triangle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class TriangleServiceTest
{
    @Test
    public void test_getPerimeter()
    {
        Point p1 = Point.of(-1, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 0);
        Triangle triangle = Triangle.of(p1, p2, p3);
        ANumber result = TriangleService.getPerimeter(triangle);
        assertTrue(ANumber.of("4.8284271247461902").equal(result));
    }


    @Test
    public void test_getArea()
    {
        Point p1 = Point.of(-1, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 0);
        Triangle triangle = Triangle.of(p1, p2, p3);
        ANumber result = TriangleService.getArea(triangle);
        assertTrue(ANumber.of(1).equal(result));
    }


    @Test
    public void test_getHypotenuse()
    {
        ANumber result = TriangleService.getHypotenuse(ANumber.of(1), ANumber.of(1));
        assertTrue(ANumber.of("1.4142135623730951").equal(result));
    }


    @Test
    public void test_isPointInsideTriangle()
    {
        Point p1 = Point.of(-1, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 0);
        Triangle triangle = Triangle.of(p1, p2, p3);
        boolean result = TriangleService.isPointInsideOrOnTriangle(triangle, Point.of(-0.5, 0.1));
        assertTrue(result);
        result = TriangleService.isPointInsideOrOnTriangle(triangle, p1);
        assertTrue(result);
        result = TriangleService.isPointInsideOrOnTriangle(triangle, Point.of(-2, 0));
        assertFalse(result);
    }


    @Test
    public void test_isPointOnTriangle()
    {
        Point p1 = Point.of(-1, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 0);
        Triangle triangle = Triangle.of(p1, p2, p3);
        boolean result = TriangleService.isPointOnTriangle(triangle, Point.of(-0.5, 0.1));
        assertFalse(result);
        result = TriangleService.isPointOnTriangle(triangle, p1);
        assertTrue(result);
        result = TriangleService.isPointOnTriangle(triangle, Point.of(-2, 0));
        assertFalse(result);
    }


    @Test
    public void test_getNumberOfLatticePoints()
    {
        Point p1 = Point.of(-1, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 0);
        Triangle triangle = Triangle.of(p1, p2, p3);
        ANumber result = TriangleService.getNumberOfLatticePoints(triangle);
        assertTrue(ANumber.of(4).equal(result));
        p1 = Point.of(3, 0);
        p2 = Point.of(0, 3);
        p3 = Point.of(0, 0);
        triangle = Triangle.of(p1, p2, p3);
        result = TriangleService.getNumberOfLatticePoints(triangle);
        assertTrue(ANumber.of(10).equal(result));
    }


    @Test
    public void test_getSideType()
    {
        Point p1 = Point.of(-1, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 0);
        Triangle triangle = Triangle.of(p1, p2, p3);
        TriangleSideType result = TriangleService.getSideType(triangle);
        assertTrue(TriangleSideType.Isosceles.is(result));
        p1 = Point.of(0, 0);
        p2 = Point.of(1, 3);
        p3 = Point.of(4, 0.5);
        triangle = Triangle.of(p1, p2, p3);
        result = TriangleService.getSideType(triangle);
        assertTrue(TriangleSideType.Scalene.is(result));
        p1 = Point.of(0, 0);
        p2 = Point.of(6, 0);
        p3 = Point.of(ANumber.of(3), ANumber.of("5.1961524227066318805823390245176"));
        triangle = Triangle.of(p1, p2, p3);
        result = TriangleService.getSideType(triangle);
        assertTrue(TriangleSideType.Equilateral.is(result));
    }


    @Test
    public void test_getAngleType()
    {
        Point p1 = Point.of(-1, 0);
        Point p2 = Point.of(0, 1);
        Point p3 = Point.of(1, 0);
        Triangle triangle = Triangle.of(p1, p2, p3);
        TriangleAngleType result = TriangleService.getAngleType(triangle);
        assertTrue(TriangleAngleType.Acute.is(result));
        p1 = Point.of(0, 0);
        p2 = Point.of(0, 1);
        p3 = Point.of(1, 0);
        triangle = Triangle.of(p1, p2, p3);
        result = TriangleService.getAngleType(triangle);
        assertTrue(TriangleAngleType.Right.is(result));
        p1 = Point.of(0, 0);
        p2 = Point.of(-1.5, 3);
        p3 = Point.of(1.5, 0);
        triangle = Triangle.of(p1, p2, p3);
        result = TriangleService.getAngleType(triangle);
        assertTrue(TriangleAngleType.Obtuse.is(result));
    }


    @Test
    public void test_getNumberOfSquaresThatCanFitInRightIsoscelesTriangle()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(8, 0);
        Point p3 = Point.of(0, 8);
        Triangle triangle = Triangle.of(p1, p2, p3);
        ANumber result = TriangleService.getNumberOfSquaresThatCanFitInRightIsoscelesTriangle(triangle, ANumber.of(2));
        assertTrue(ANumber.of(6).equal(result));
    }


    @Test
    public void test_getAngleBetweenSidesBAndCUsingLawOfCosines()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(8, 0);
        Point p3 = Point.of(0, 8);
        Triangle triangle = Triangle.of(p1, p2, p3);
        ANumber result = TriangleService.getAngleBetweenSidesBAndCUsingLawOfCosines(triangle);
        assertTrue(ANumber.of("1.5707963267948966").equal(result));
    }


    @Test
    public void test_getAngleBetweenSidesAAndBUsingLawOfCosines()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(8, 0);
        Point p3 = Point.of(0, 8);
        Triangle triangle = Triangle.of(p1, p2, p3);
        ANumber result = TriangleService.getAngleBetweenSidesAAndBUsingLawOfCosines(triangle);
        assertTrue(ANumber.of("0.7853981633974476").equal(result));
    }


    @Test
    public void test_getAngleBetweenSidesAAndCUsingLawOfCosines()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(8, 0);
        Point p3 = Point.of(0, 8);
        Triangle triangle = Triangle.of(p1, p2, p3);
        ANumber result = TriangleService.getAngleBetweenSidesAAndCUsingLawOfCosines(triangle);
        assertTrue(ANumber.of("0.7853981633974476").equal(result));
    }


    @Test
    public void test_getCircumcenter()
    {
        Point p1 = Point.of(-1, -2);
        Point p2 = Point.of(2, 3);
        Point p3 = Point.of(3, -3);
        Triangle triangle = Triangle.of(p1, p2, p3);
        Point result = TriangleService.getCircumcenter(triangle);
        assertTrue(Point.of(ANumber.of("1.587391304347826080055"), ANumber.of("-0.1524347826086956480328922495274102259")).equals(result));
    }


    @Test
    public void test_isSimilarTo()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(8, 0);
        Point p3 = Point.of(0, 8);
        Triangle triangle1 = Triangle.of(p1, p2, p3);
        Point p4 = Point.of(1, 0);
        Point p5 = Point.of(9, 0);
        Point p6 = Point.of(1, 8);
        Triangle triangle2 = Triangle.of(p4, p5, p6);
        boolean result = TriangleService.isSimilarTo(triangle1, triangle2);
        assertTrue(result);
        p6 = Point.of(1, 8.00001);
        triangle2 = Triangle.of(p4, p5, p6);
        result = TriangleService.isSimilarTo(triangle1, triangle2);
        assertFalse(result);
    }
}