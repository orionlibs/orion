package com.orion.math.geometry.shape.line;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.geometry.Axis;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.services.NumberService;
import java.util.Arrays;

public class Line implements MathObject, Cloneable
{
    private ANumber a;
    private ANumber b;
    private ANumber c;
    private ANumber slope;
    private ANumber interceptForSlopeForm;
    private Function2x1<ANumber, ANumber, ANumber> formula;
    private Function1x1<ANumber, ANumber> formulaToFindY;
    private Function2x1<ANumber, ANumber, ANumber> formulaSlopeForm;
    private Function1x1<ANumber, ANumber> formulaSlopeFormToFindY;
    private boolean hasCBeingNegatedDuringNormalisation;


    public Line(ANumber a, ANumber b, ANumber c)
    {
        NumberRules.areNotNull(a, b, c);
        this.a = a.getCopy();
        this.b = b.getCopy();
        this.c = c.getCopy();
        normaliseCoefficients();
        setFormula();
        setFormulaToFindY();
        this.slope = getA().divideGET(getB()).negateGET();
        makeBZeroIfLineIsParallelToYAxis();
        calculateInterceptForSlopeForm();
        setFormulaSlopeForm();
        setFormulaSlopeFormToFindY();
    }


    public Line(ANumber slope, ANumber intercept)
    {
        NumberRules.areNotNull(slope, intercept);
        this.slope = slope;
        this.interceptForSlopeForm = intercept;
        this.a = slope.negateGET();
        this.b = ANumber.of(1);
        this.c = intercept.negateGET();
        makeAPositive();
        makeBZeroIfLineIsParallelToYAxis();
        setFormula();
        setFormulaToFindY();
        setFormulaSlopeForm();
        setFormulaSlopeFormToFindY();
    }


    public Line(Number slope, Number intercept)
    {
        this(ANumber.of(slope), ANumber.of(intercept));
    }


    public Line(Point point1, Point point2)
    {
        PointRules.areValid(point1, point2);
        this.a = point2.getY().subtractGET(point1.getY());
        this.b = point1.getX().subtractGET(point2.getX());
        this.c = point1.getX().multiplyGET(a).addGET(point1.getY().multiplyGET(b)).negateGET();
        normaliseCoefficients();
        setFormula();
        setFormulaToFindY();
        this.slope = getA().divideGET(getB()).negateGET();
        makeBZeroIfLineIsParallelToYAxis();
        calculateInterceptForSlopeForm();
        setFormulaSlopeForm();
        setFormulaSlopeFormToFindY();
    }


    public static Line of(ANumber a, ANumber b, ANumber c)
    {
        return new Line(a, b, c);
    }


    public static Line of(Number a, Number b, Number c)
    {
        NumberRules.areNotNull(a, b, c);
        return new Line(ANumber.of(a), ANumber.of(b), ANumber.of(c));
    }


    public static Line of(ANumber slope, ANumber intercept)
    {
        return new Line(slope, intercept);
    }


    public static Line of(Number slope, Number intercept)
    {
        return new Line(slope, intercept);
    }


    public static Line of(Point point1, Point point2)
    {
        return new Line(point1, point2);
    }


    public static Line ofParallelToXAxis(ANumber interceptWithYAxis)
    {
        Point point1 = Point.of(ANumber.of(0), interceptWithYAxis);
        Point point2 = Point.of(ANumber.of(1), interceptWithYAxis);
        return of(point1, point2);
    }


    public static Line ofParallelToXAxis(Number interceptWithYAxis)
    {
        return ofParallelToXAxis(ANumber.of(interceptWithYAxis));
    }


    public static Line ofParallelToYAxis(ANumber interceptWithXAxis)
    {
        Point point1 = Point.of(interceptWithXAxis, ANumber.of(0));
        Point point2 = Point.of(interceptWithXAxis, ANumber.of(1));
        return of(point1, point2);
    }


    public static Line ofParallelToYAxis(Number interceptWithXAxis)
    {
        return ofParallelToYAxis(ANumber.of(interceptWithXAxis));
    }


    private void normaliseCoefficients()
    {
        reduceCoefficients();
        makeAPositive();
    }


    private void makeAPositive()
    {

        if(a.isNegative() && !a.isNegativeInfiniteNumber())
        {
            a.negate();
            b.negate();
            c.negate();
            hasCBeingNegatedDuringNormalisation = true;
        }

    }


    private void calculateInterceptForSlopeForm()
    {

        if(getB().hasInfiniteValue())
        {
            this.interceptForSlopeForm = getC().negateGET().divideGET(getB());
        }
        else if(getA().isZero())
        {
            this.interceptForSlopeForm = getC();
        }
        else
        {

            if(getB().isZero())
            {
                this.interceptForSlopeForm = getC().divideGET(getA()).negateGET();
            }
            else
            {
                this.interceptForSlopeForm = getC().divideGET(getB());

                if(hasCBeingNegatedDuringNormalisation)
                {
                    interceptForSlopeForm = interceptForSlopeForm.negateGET();
                }

            }

        }

    }


    private void reduceCoefficients()
    {

        if(a.hasIntegerValue() && b.hasIntegerValue() && c.hasIntegerValue())
        {
            ANumber gcd = NumberService.getGreatestCommonDivisor(Arrays.asList(a.getAbsoluteValue(), b.getAbsoluteValue(), c.getAbsoluteValue()));
            this.a = this.a.divideGET(gcd);
            this.b = this.b.divideGET(gcd);
            this.c = this.c.divideGET(gcd);
        }

    }


    private void makeBZeroIfLineIsParallelToYAxis()
    {

        if(slope.hasInfiniteValue())
        {
            b = ANumber.of(0);
        }

    }


    private void setFormula()
    {
        Function2x1IF<ANumber, ANumber, ANumber> formulaFunction = (ANumber x, ANumber y) ->
        {
            return a.multiplyGET(x).addGET(b.multiplyGET(y)).addGET(c);
        };
        formula = new Function2x1<ANumber, ANumber, ANumber>(formulaFunction);
    }


    private void setFormulaToFindY()
    {
        Function1x1IF<ANumber, ANumber> formulaToFindYFunction = (ANumber x) ->
        {
            return a.multiplyGET(x).addGET(c).divideGET(b).negateGET();
        };
        formulaToFindY = new Function1x1<ANumber, ANumber>(formulaToFindYFunction);
    }


    private void setFormulaSlopeForm()
    {
        Function2x1IF<ANumber, ANumber, ANumber> formulaSlopeFormFunction = (ANumber x, ANumber y) ->
        {
            return y.subtractGET(slope.multiplyGET(x)).subtractGET(interceptForSlopeForm);
        };
        formulaSlopeForm = new Function2x1<ANumber, ANumber, ANumber>(formulaSlopeFormFunction);
    }


    private void setFormulaSlopeFormToFindY()
    {
        Function1x1IF<ANumber, ANumber> formulaSlopeFormToFindYFunction = (ANumber x) ->
        {
            return interceptForSlopeForm.addGET(slope.multiplyGET(x));
        };
        formulaSlopeFormToFindY = new Function1x1<ANumber, ANumber>(formulaSlopeFormToFindYFunction);
    }


    public ANumber getYUsingSlopeForm(ANumber x)
    {
        return getFormulaSlopeFormToFindY().run(x);
    }


    public ANumber getDistanceFromPoint(Point point)
    {
        return LineService.getDistanceFromPoint(this, point);
    }


    public ANumber getDistanceFromPoint(Point point, int precision)
    {
        return LineService.getDistanceFromPoint(this, point, precision);
    }


    public boolean doesPointBelongToLine(Point point)
    {
        PointRules.isValid(point);
        return formula.run(point.getX(), point.getY()).isZero();
    }


    public boolean doesPointNotBelongToLine(Point point)
    {
        return !doesPointBelongToLine(point);
    }


    public boolean doesIntersect(Line other)
    {
        return LineService.doesIntersect(this, other);
    }


    public Point getIntersectionPoint(Line other)
    {
        return LineService.getIntersectionPoint(this, other);
    }


    public boolean isParallelTo(Line other)
    {
        return LineService.isParallelTo(this, other);
    }


    public boolean isParallelTo(Line other, int precision)
    {
        return LineService.isParallelTo(this, other, precision);
    }


    public boolean isNotParallelTo(Line other)
    {
        return LineService.isNotParallelTo(this, other);
    }


    public boolean isNotParallelTo(Line other, int precision)
    {
        return LineService.isNotParallelTo(this, other, precision);
    }


    public boolean isParallelToXAxis()
    {
        return isParallelTo(Line.of(0, 0));
    }


    public boolean isNotParallelToXAxis()
    {
        return isNotParallelTo(Line.of(0, 0));
    }


    public boolean isParallelToYAxis()
    {
        Vector yAxisBasedVector = VectorService.getBasisVector(2, Axis.Y);
        return isVerticalTo(Line.of(yAxisBasedVector.getStartPoint(), yAxisBasedVector.getEndPoint()));
    }


    public boolean isNotParallelToYAxis()
    {
        return isNotParallelTo(Line.of(0, 0));
    }


    public boolean isVerticalTo(Line other)
    {
        return LineService.isVerticalTo(this, other);
    }


    public boolean isVerticalTo(Line other, int precision)
    {
        return LineService.isVerticalTo(this, other, precision);
    }


    public boolean isNotVerticalTo(Line other)
    {
        return LineService.isNotVerticalTo(this, other);
    }


    public boolean isNotVerticalTo(Line other, int precision)
    {
        return LineService.isNotVerticalTo(this, other, precision);
    }


    public boolean isLineTangentToCircle(Circle circle)
    {
        return LineService.isLineTangentToCircle(this, circle);
    }


    public boolean isLineTangentToCircle(Circle circle, int precision)
    {
        return LineService.isLineTangentToCircle(this, circle, precision);
    }


    public boolean doesLineIntersectCircle(Circle circle)
    {
        return LineService.doesLineIntersectCircle(this, circle);
    }


    public boolean doesLineIntersectCircle(Circle circle, int precision)
    {
        return LineService.doesLineIntersectCircle(this, circle, precision);
    }


    @Override
    public Line clone() throws CloneNotSupportedException
    {
        return (Line)CloningService.clone(this);
    }


    public Line getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public int hashCode()
    {
        return LineInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return LineInternalService.equals(this, object);
    }


    public ANumber getA()
    {
        return this.a;
    }


    public ANumber getB()
    {
        return this.b;
    }


    public ANumber getC()
    {
        return this.c;
    }


    public Function2x1<ANumber, ANumber, ANumber> getFormula()
    {
        return this.formula;
    }


    public Function2x1<ANumber, ANumber, ANumber> getFormulaSlopeForm()
    {
        return this.formulaSlopeForm;
    }


    public ANumber getSlope()
    {
        return this.slope;
    }


    public ANumber getSlope(int precision)
    {
        return this.slope.applyPrecisionGET(precision);
    }


    public ANumber getInterceptForSlopeForm()
    {
        return this.interceptForSlopeForm;
    }


    public Function1x1<ANumber, ANumber> getFormulaToFindY()
    {
        return this.formulaToFindY;
    }


    public Function1x1<ANumber, ANumber> getFormulaSlopeFormToFindY()
    {
        return this.formulaSlopeFormToFindY;
    }
}