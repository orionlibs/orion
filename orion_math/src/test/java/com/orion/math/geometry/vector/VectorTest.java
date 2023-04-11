package com.orion.math.geometry.vector;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class VectorTest
{
    @Test
    public void testAdd1()
    {
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector expected = Vector.of(new ANumber[]
        {ANumber.of(5), ANumber.of(7), ANumber.of(9)});
        assertTrue(expected.equals(vector1.add(vector2)));
    }


    @Test
    public void testAdd2()
    {
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Point startPoint2 = Point.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(0)});
        Point endPoint2 = Point.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector2 = Vector.of(startPoint2, endPoint2);
        Vector expected = Vector.of(new ANumber[]
        {ANumber.of(5), ANumber.of(7), ANumber.of(9)});
        assertTrue(expected.equals(vector1.add(vector2)));
    }


    @Test
    public void testAdd3()
    {
        Point startPoint1 = Point.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(0)});
        Point endPoint1 = Point.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector1 = Vector.of(startPoint1, endPoint1);
        Point startPoint2 = Point.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(0)});
        Point endPoint2 = Point.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector2 = Vector.of(startPoint2, endPoint2);
        Vector expected = Vector.of(new ANumber[]
        {ANumber.of(5), ANumber.of(7), ANumber.of(9)});
        assertTrue(expected.equals(vector1.add(vector2)));
    }


    @Test
    public void testAdd4()
    {
        Point startPoint1 = Point.of(new ANumber[]
        {ANumber.of(10), ANumber.of(11), ANumber.of(12)});
        Point endPoint1 = Point.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector1 = Vector.of(startPoint1, endPoint1);
        Point startPoint2 = Point.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        Point endPoint2 = Point.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(startPoint2, endPoint2);
        Point startPointExpected = Point.of(new ANumber[]
        {ANumber.of(17), ANumber.of(19), ANumber.of(21)});
        Point endPointExpected = Point.of(new ANumber[]
        {ANumber.of(5), ANumber.of(7), ANumber.of(9)});
        Vector expected = Vector.of(startPointExpected, endPointExpected);
        assertTrue(expected.equals(vector1.add(vector2)));
    }


    @Test
    public void testSubtract()
    {
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector expected = Vector.of(new ANumber[]
        {ANumber.of(-3), ANumber.of(-3), ANumber.of(-3)});
        assertTrue(expected.equals(vector1.subtract(vector2)));
    }


    @Test
    public void testMultiply_scalar()
    {
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector expected = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(6), ANumber.of(9)});
        assertTrue(expected.equals(vector1.multiply(ANumber.of(3))));
    }


    @Test
    public void testGetMagnitude()
    {
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        ANumber expected = ANumber.of(14).getSquareRoot();
        assertTrue(expected.equals(vector1.getMagnitude()));
    }


    @Test
    public void testNormalise()
    {
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        ANumber magnitude = ANumber.of(14).getSquareRoot();
        Vector expected = Vector.of(new ANumber[]
        {ANumber.of(1).divideGET(magnitude), ANumber.of(2).divideGET(magnitude), ANumber.of(3).divideGET(magnitude)});
        assertTrue(expected.equals(vector1.normalise()));
    }


    @Test
    public void testTranslate()
    {
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector expected = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        assertTrue(expected.equals(vector1.translate(ANumber.of(3))));
    }


    @Test
    public void testGetAngleWithXAxisAsDegrees()
    {
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(1)});
        ANumber expected = ANumber.of(
                        "45.00000000000004528568682677118244478040012470034795293296253941304508779907713248736491885964771108760198315260906474303937919125366601359850129801011747485616654545662605985754019161624697841526926410537919262390968574240565727997580305834584136665978640073818353181526082233481123492716639582949347968190023378345821379378396761745382227885944330096341404009567951787328288551252259321449488488149536883200857619910397330499862571661662150273001825201978964606782808015",
                        "0");
        assertTrue(expected.equal(vector1.getAngleWithXAxisAsDegrees()));
    }


    @Test
    public void testGetEqualVectorBasedOnPoint()
    {
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(1)});
        Point point = Point.of(new ANumber[]
        {ANumber.of(2), ANumber.of(0)});
        Point point1Expected = Point.of(new ANumber[]
        {ANumber.of(2), ANumber.of(0)});
        Point point2Expected = Point.of(new ANumber[]
        {ANumber.of(3), ANumber.of(1)});
        Vector expected = Vector.of(point1Expected, point2Expected);
        assertTrue(expected.equals(vector1.getEqualVectorBasedOnPoint(point)));
    }
}