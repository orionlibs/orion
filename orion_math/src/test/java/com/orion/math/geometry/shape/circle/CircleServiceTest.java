package com.orion.math.geometry.shape.circle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class CircleServiceTest
{
    @Test
    public void test_getCircumference()
    {
        Point p1 = Point.of(1, 0);
        Point p2 = Point.of(-1, 0);
        Point p3 = Point.of(0, 1);
        Circle circle = Circle.of(p1, p2, p3);
        ANumber result = CircleService.getCircumference(circle);
        assertTrue(ANumber.of(
                        "6.28318530717958647692528676655900576839433879875021164194988918461563281257241799725606965068423413596429617302656461329418768921910116446345071881625696223490056820540387704221111928924589790986076392885762195133186689225695129646757356633054240381829129713384692069722090865329642678721452049828254744917401321263117634976304184192565850818343072873578518072002266106109764093304276829390388302321886611454073151918390618437223476386522358621023709614892")
                        .equal(result));
    }


    @Test
    public void test_getArea()
    {
        Point p1 = Point.of(1, 0);
        Point p2 = Point.of(-1, 0);
        Point p3 = Point.of(0, 1);
        Circle circle = Circle.of(p1, p2, p3);
        ANumber result = CircleService.getArea(circle);
        assertTrue(ANumber.of(
                        "3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706798214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196442881097566593344612847564823378678316527120190914564856692346034861045432664821339360726024914127372458700660631558817488152092096282925409171536436789259036001133053054882046652138414695194151160943305727036575959195309218611738193261179310511854807446")
                        .equal(result));
    }


    @Test
    public void test_isPointInsideCircle()
    {
        Point p1 = Point.of(1, 0);
        Point p2 = Point.of(-1, 0);
        Point p3 = Point.of(0, 1);
        Circle circle = Circle.of(p1, p2, p3);
        boolean result = CircleService.isPointInsideCircle(circle, Point.of(0.1, 0.1));
        assertTrue(result);
        result = CircleService.isPointInsideCircle(circle, Point.of(-1, 0));
        assertFalse(result);
        result = CircleService.isPointInsideCircle(circle, Point.of(1, 0));
        assertFalse(result);
        result = CircleService.isPointInsideCircle(circle, Point.of(0, -1));
        assertFalse(result);
        result = CircleService.isPointInsideCircle(circle, Point.of(0, 1));
        assertFalse(result);
        result = CircleService.isPointInsideCircle(circle, Point.of(0.000000001d, 1.0000000001d));
        assertFalse(result);
        result = CircleService.isPointInsideCircle(circle, Point.of(ANumber.of(0), ANumber.of("0.999999999")));
        assertTrue(result);
    }


    @Test
    public void test_isPointOnCircle()
    {
        Point p1 = Point.of(1, 0);
        Point p2 = Point.of(-1, 0);
        Point p3 = Point.of(0, 1);
        Circle circle = Circle.of(p1, p2, p3);
        boolean result = CircleService.isPointOnCircle(circle, Point.of(0.1, 0.1));
        assertFalse(result);
        result = CircleService.isPointOnCircle(circle, Point.of(-1, 0));
        assertTrue(result);
        result = CircleService.isPointOnCircle(circle, Point.of(1, 0));
        assertTrue(result);
        result = CircleService.isPointOnCircle(circle, Point.of(0, -1));
        assertTrue(result);
        result = CircleService.isPointOnCircle(circle, Point.of(0, 1));
        assertTrue(result);
        result = CircleService.isPointOnCircle(circle, Point.of(0.000000001d, 1.0000000001d));
        assertFalse(result);
        result = CircleService.isPointOnCircle(circle, Point.of(ANumber.of(0), ANumber.of("0.999999999")));
        assertFalse(result);
    }


    @Test
    public void test_getNumberOfLatticePoints()
    {
        Point p1 = Point.of(1, 0);
        Point p2 = Point.of(-1, 0);
        Point p3 = Point.of(0, 1);
        Circle circle = Circle.of(p1, p2, p3);
        ANumber result = CircleService.getNumberOfLatticePoints(circle);
        assertTrue(ANumber.of(4).equal(result));
    }


    @Test
    public void test_getAngleBetween()
    {
        Point p1 = Point.of(1, 0);
        Point p2 = Point.of(-1, 0);
        Point p3 = Point.of(0, 1);
        Circle circle = Circle.of(p1, p2, p3);
        ANumber result = CircleService.getAngleAsRadiansBetween(circle, Point.of(-1, 0), Point.of(1, 0));
        assertTrue(ANumber.of("3.141592653589793").equal(result));
        result = CircleService.getAngleAsRadiansBetween(circle, Point.of(0, -1), Point.of(1, 0));
        assertTrue(ANumber.of(
                        "1.57079632679489661923132169163975144209858469968755291048747229615390820314310449931401741267105853399107404325664115332354692230477529111586267970406424055872514205135096926055277982231147447746519098221440548783296672306423782411689339158263560095457282428346173017430522716332410669680363012457063686229350330315779408744076046048141462704585768218394629518000566526527441023326069207347597075580471652863518287979597654609305869096630589655255927403723")
                        .equal(result));
    }


    @Test
    public void test_getEndPointBasedOn()
    {
        Point p1 = Point.of(1, 0);
        Point p2 = Point.of(-1, 0);
        Point p3 = Point.of(0, 1);
        Circle circle = Circle.of(p1, p2, p3);
        Point result = CircleService.getCirclePointBasedOn(circle, Point.of(1, 0), ANumber.of("0.78539816339744830961566084581988"));
        assertTrue(Point.of(ANumber.of("0.7071067811865478"), ANumber.of("0.7071067811865472")).equals(result));
    }


    @Test
    public void test_doCirclesIntersect1()
    {
        Point p1 = Point.of(0, 0);
        Point p2 = Point.of(2, 0);
        Point p3 = Point.of(1, -1);
        Circle circle1 = Circle.of(p1, p2, p3);
        Point p4 = Point.of(0, 0);
        Point p5 = Point.of(-1, -1);
        Point p6 = Point.of(-2, 0);
        Circle circle2 = Circle.of(p4, p5, p6);
        boolean result = CircleService.doCirclesIntersect(circle1, circle2);
        assertTrue(result);
    }


    @Test
    public void test_doCirclesIntersect2()
    {
        Point p1 = Point.of(1.5, 0);
        Point p2 = Point.of(0.5, -1);
        Point p3 = Point.of(-0.5, 0);
        Circle circle1 = Circle.of(p1, p2, p3);
        Point p4 = Point.of(0.5, 0);
        Point p5 = Point.of(-0.5, -1);
        Point p6 = Point.of(-0.5, 1);
        Circle circle2 = Circle.of(p4, p5, p6);
        boolean result = CircleService.doCirclesIntersect(circle1, circle2);
        assertTrue(result);
    }


    @Test
    public void test_doCirclesIntersect3()
    {
        Point p1 = Point.of(1, 0);
        Point p2 = Point.of(2, -1);
        Point p3 = Point.of(3, 0);
        Circle circle1 = Circle.of(p1, p2, p3);
        Point p4 = Point.of(-1, 0);
        Point p5 = Point.of(-2, -1);
        Point p6 = Point.of(-3, 0);
        Circle circle2 = Circle.of(p4, p5, p6);
        boolean result = CircleService.doCirclesIntersect(circle1, circle2);
        assertFalse(result);
    }


    @Test
    public void test_getTangentLineOnPoint1()
    {
        Point p1 = Point.of(1, 0);
        Point p2 = Point.of(2, -1);
        Point p3 = Point.of(3, 0);
        Circle circle = Circle.of(p1, p2, p3);
        Line result = CircleService.getTangentLineOnPoint(circle, Point.of(3, 0));
        assertTrue(result.getA().equal(ANumber.of(1)));
        assertTrue(result.getB().equal(ANumber.of(0)));
        assertTrue(result.getC().equal(ANumber.of(-3)));
    }


    @Test
    public void test_getTangentLineOnPoint2()
    {
        Point center = Point.of(-3, 1);
        Circle circle = Circle.of(center, ANumber.of(17).getSquareRoot());
        Line result = CircleService.getTangentLineOnPoint(circle, Point.of(-2, 5));
        assertTrue(result.getA().equal(ANumber.of(0.25)));
        assertTrue(result.getB().equal(ANumber.of(1)));
        assertTrue(result.getC().equal(ANumber.of(-4.5)));
    }


    @Test
    public void test_getCircleThatEnclosesPoints()
    {
        Point p1 = Point.of(1, 0);
        Point p2 = Point.of(2, -0.9);
        Point p3 = Point.of(3, 0);
        Point p4 = Point.of(1.5, 0.1);
        Circle result = CircleService.getCircleThatEnclosesPoints(OrionArrayList.<Point>of(p1, p2, p3, p4));
        assertTrue(result.getCenter().equals(Point.of(2, 0)));
        assertTrue(result.getRadius().equal(ANumber.of(1)));
    }
}