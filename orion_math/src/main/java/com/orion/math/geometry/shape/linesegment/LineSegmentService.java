package com.orion.math.geometry.shape.linesegment;

import com.orion.core.abstraction.OrionService;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.RelativePosition;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.linesegment.tasks.DivideLineSegmentWithRatioTask;
import com.orion.math.geometry.shape.linesegment.tasks.GetLengthOfUnionOfLineSegmentsTask;
import com.orion.math.geometry.shape.linesegment.tasks.GetLineFromLineSegmentTask;
import com.orion.math.geometry.shape.linesegment.tasks.GetPerpendicularBisectorOfLineSegmentTask;
import com.orion.math.geometry.shape.linesegment.tasks.GetPositionOfPointRelativeToLineSegmentTask;
import com.orion.math.geometry.shape.linesegment.tasks.check.AreLineSegmentsColinearTask;
import com.orion.math.geometry.shape.linesegment.tasks.check.DoesLineSegmentIntersectTask;
import com.orion.math.geometry.shape.linesegment.tasks.check.IsPointOnLineSegmentTask;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class LineSegmentService extends OrionService
{
    public static Line getLine(LineSegment x)
    {
        return GetLineFromLineSegmentTask.run(x);
    }


    public static boolean doesIntersect(LineSegment x, LineSegment other)
    {
        return DoesLineSegmentIntersectTask.run(x, other);
    }


    public static boolean isPointOnLineSegment(LineSegment x, Point point)
    {
        return IsPointOnLineSegmentTask.run(x, point);
    }


    public static boolean isCollinearTo(LineSegment x, LineSegment other)
    {
        LineSegmentRules.areValid(x, other);
        return x.getLine().equals(other.getLine());
    }


    public static boolean isNotCollinearTo(LineSegment x, LineSegment other)
    {
        return !isCollinearTo(x, other);
    }


    public static boolean areCollinear(LineSegment... lineSegments)
    {
        return AreLineSegmentsColinearTask.run(lineSegments);
    }


    public static ANumber getLengthOfUnionOnTheSameLine(LineSegment[] lineSegments)
    {
        return getLengthOfUnionOnTheSameLine(lineSegments, Precision.precision);
    }


    public static ANumber getLengthOfUnionOnTheSameLine(LineSegment[] lineSegments, int precision)
    {
        LineSegmentRules.areValid(lineSegments);

        if(areCollinear(lineSegments))
        {
            return GetLengthOfUnionOfLineSegmentsTask.run(lineSegments, precision);
        }
        else
        {
            return ANumber.of(0);
        }

    }


    public static ANumber getAngleWithXAxisAsRadians(LineSegment x)
    {
        LineSegmentRules.isValid(x);
        return Vector.of(x.getStartPoint(), x.getEndPoint()).getAngleWithXAxisAsRadians();
    }


    public static ANumber getAngleWithXAxisAsRadians(LineSegment x, int precision)
    {
        LineSegmentRules.isValid(x);
        return Vector.of(x.getStartPoint(), x.getEndPoint()).getAngleWithXAxisAsRadians(precision);
    }


    public static boolean isPerpendicularTo(LineSegment x, LineSegment other)
    {
        LineSegmentRules.areValid(x, other);
        return x.getLine().getSlope().multiplyGET(other.getLine().getSlope()).equal(ANumber.of(-1));
    }


    public static boolean isPerpendicularTo(LineSegment x, LineSegment other, int precision)
    {
        LineSegmentRules.areValid(x, other);
        return x.getLine().getSlope(precision).multiplyGET(other.getLine().getSlope(precision)).equal(ANumber.of(-1));
    }


    public static boolean isParallelTo(LineSegment x, LineSegment other)
    {
        LineSegmentRules.areValid(x, other);
        return x.getLine().getSlope().equal(other.getLine().getSlope());
    }


    public static boolean isParallelTo(LineSegment x, LineSegment other, int precision)
    {
        LineSegmentRules.areValid(x, other);
        return x.getLine().getSlope(precision).equal(other.getLine().getSlope(precision));
    }


    public static boolean isParallelToXAxis(LineSegment x)
    {
        LineSegmentRules.isValid(x);
        return x.getLine().getSlope().isZero();
    }


    public static boolean isParallelToXAxis(LineSegment x, int precision)
    {
        LineSegmentRules.isValid(x);
        return x.getLine().getSlope(precision).isZero();
    }


    public static Line getPerpendicularBisector(LineSegment x)
    {
        return GetPerpendicularBisectorOfLineSegmentTask.run(x);
    }


    public static Point getMidpoint(LineSegment x)
    {
        LineSegmentRules.isValid(x);
        return x.getAsVector().getMidpoint();
    }


    public static RelativePosition getPositionOfPointRelativeToLineSegment(LineSegment x, Point point)
    {
        return GetPositionOfPointRelativeToLineSegmentTask.run(x, point);
    }


    public static boolean doesPointLieOnTheLeft(LineSegment x, Point point)
    {
        return getPositionOfPointRelativeToLineSegment(x, point).is(RelativePosition.Left);
    }


    public static boolean doesPointLieOnTheRight(LineSegment x, Point point)
    {
        return getPositionOfPointRelativeToLineSegment(x, point).is(RelativePosition.Right);
    }


    public static Pair<LineSegment, LineSegment> divideLineSegmentWithRatio(LineSegment x, ANumber ratio)
    {
        return DivideLineSegmentWithRatioTask.run(x, ratio);
    }


    public static boolean doesLinePassThroughPointOfOrigin(LineSegment x)
    {
        LineSegmentRules.isValid(x);
        return x.getLine().getFormulaToFindY().run(ANumber.of(0)).isZero();
    }


    public static boolean isEquipollentTo(LineSegment x, LineSegment other)
    {
        LineSegmentRules.areValid(x, other);
        return x.getLength().equal(other.getLength())
                        && x.getAngleWithXAxisAsRadians().equal(other.getAngleWithXAxisAsRadians());
    }
}