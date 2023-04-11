package com.orion.math.geometry.shape.linesegment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.tuple.Pair;
import com.orion.math.geometry.RelativePosition;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class LineSegmentServiceTest
{
    @Test
    public void test_getLine()
    {
        LineSegment ls = LineSegment.of(Point.of(0, 0), Point.of(2, 2));
        Line result = LineSegmentService.getLine(ls);
        assertTrue(Line.of(-1, 1, 0).equals(result));
        ls = LineSegment.of(Point.of(2, 2), Point.of(2, 3));
        result = LineSegmentService.getLine(ls);
        assertTrue(Line.of(1, 0, -2).equals(result));
    }


    @Test
    public void test_doesIntersect()
    {
        LineSegment ls1 = LineSegment.of(Point.of(0, 0), Point.of(2, 2));
        LineSegment ls2 = LineSegment.of(Point.of(0, 0), Point.of(2, 2));
        boolean result = LineSegmentService.doesIntersect(ls1, ls2);
        assertTrue(result);
        ls2 = LineSegment.of(Point.of(0, 0), Point.of(0.1, 0.1));
        result = LineSegmentService.doesIntersect(ls1, ls2);
        assertTrue(result);
        ls2 = LineSegment.of(Point.of(0, 1), Point.of(1.5, -2));
        result = LineSegmentService.doesIntersect(ls1, ls2);
        assertTrue(result);
        ls2 = LineSegment.of(Point.of(-3, 4), Point.of(-2, 5));
        result = LineSegmentService.doesIntersect(ls1, ls2);
        assertFalse(result);
    }


    @Test
    public void test_isPointOnLineSegment()
    {
        LineSegment ls = LineSegment.of(Point.of(0, 0), Point.of(2, 2));
        boolean result = LineSegmentService.isPointOnLineSegment(ls, Point.of(1, 1));
        assertTrue(result);
        ls = LineSegment.of(Point.of(2, 2), Point.of(2, 3));
        result = LineSegmentService.isPointOnLineSegment(ls, Point.of(1, 1.1));
        assertFalse(result);
    }


    @Test
    public void test_isCollinearTo()
    {
        LineSegment ls1 = LineSegment.of(Point.of(0, 0), Point.of(2, 2));
        LineSegment ls2 = LineSegment.of(Point.of(0, 0), Point.of(1, 1));
        boolean result = LineSegmentService.isCollinearTo(ls1, ls2);
        assertTrue(result);
        ls2 = LineSegment.of(Point.of(0, 0), Point.of(2, 2.1));
        result = LineSegmentService.isCollinearTo(ls1, ls2);
        assertFalse(result);
    }


    @Test
    public void test_getPositionOfPointRelativeToLineSegment()
    {
        LineSegment ls = LineSegment.of(Point.of(0, 0), Point.of(2, 2));
        RelativePosition result = LineSegmentService.getPositionOfPointRelativeToLineSegment(ls, Point.of(-1, 3));
        assertTrue(RelativePosition.Left.is(result));
        result = LineSegmentService.getPositionOfPointRelativeToLineSegment(ls, Point.of(1, 1));
        assertTrue(RelativePosition.On.is(result));
        result = LineSegmentService.getPositionOfPointRelativeToLineSegment(ls, Point.of(2, 0.1));
        assertTrue(RelativePosition.Right.is(result));
    }


    @Test
    public void test_divideLineSegmentWithRatio()
    {
        LineSegment ls = LineSegment.of(Point.of(0, 0), Point.of(3, 3));
        Pair<LineSegment, LineSegment> result = LineSegmentService.divideLineSegmentWithRatio(ls, ANumber.of(1));
        assertTrue(Point.of(0, 0).equals(result.getFirst().getStartPoint()));
        assertTrue(Point.of(1.5, 1.5).equals(result.getFirst().getEndPoint()));
        assertTrue(Point.of(1.5, 1.5).equals(result.getSecond().getStartPoint()));
        assertTrue(Point.of(3, 3).equals(result.getSecond().getEndPoint()));
        result = LineSegmentService.divideLineSegmentWithRatio(ls, ANumber.of(0.5));
        assertTrue(Point.of(0, 0).equals(result.getFirst().getStartPoint()));
        assertTrue(Point.of(1, 1).equals(result.getFirst().getEndPoint()));
        assertTrue(Point.of(1, 1).equals(result.getSecond().getStartPoint()));
        assertTrue(Point.of(3, 3).equals(result.getSecond().getEndPoint()));
    }


    @Test
    public void test_doesLinePassThroughPointOfOrigin()
    {
        LineSegment ls = LineSegment.of(Point.of(0, 0), Point.of(2, 2));
        boolean result = LineSegmentService.doesLinePassThroughPointOfOrigin(ls);
        assertTrue(result);
        ls = LineSegment.of(Point.of(1, 1), Point.of(3, 7));
        result = LineSegmentService.doesLinePassThroughPointOfOrigin(ls);
        assertFalse(result);
        Line line = ls.getLine();
        assertTrue(ANumber.of(3).equal(line.getSlope()));
        assertTrue(ANumber.of(-2).equal(line.getInterceptForSlopeForm()));
    }


    @Test
    public void test_getPerpendicularBisectorBetweenPoints()
    {
        Point p1 = Point.of(1, 1);
        Point p2 = Point.of(2, 2);
        Line result = LineSegmentService.getPerpendicularBisector(LineSegment.of(p1, p2));
        assertTrue(Line.of(-1, -1, 3).equals(result));
        p1 = Point.of(-1, 3);
        p2 = Point.of(1, 3);
        result = LineSegmentService.getPerpendicularBisector(LineSegment.of(p1, p2));
        assertTrue(Line.ofParallelToYAxis(0).equals(result));
        p1 = Point.of(3, 0);
        p2 = Point.of(3, 2);
        result = LineSegmentService.getPerpendicularBisector(LineSegment.of(p1, p2));
        assertTrue(Line.ofParallelToXAxis(1).equals(result));
        p1 = Point.of(3, 0);
        p2 = Point.of(2, 2);
        result = LineSegmentService.getPerpendicularBisector(LineSegment.of(p1, p2));
        assertTrue(Line.of(-1, 2, 0.5).equals(result));
    }
}