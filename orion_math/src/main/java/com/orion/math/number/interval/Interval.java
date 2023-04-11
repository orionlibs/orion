package com.orion.math.number.interval;

import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.number.ANumber;

public class Interval implements MathObject, Cloneable, Comparable<Interval>
{
    private ANumber leftEndpoint;
    private ANumber rightEndpoint;
    private boolean leftClosed;
    private boolean rightClosed;
    private boolean isEmpty;
    private boolean isInfinite;
    private boolean isLeftInfinite;
    private boolean isRightInfinite;


    public Interval()
    {
        this.isEmpty = true;
    }


    public Interval(boolean isInfinite)
    {
        this(true, true);
    }


    public Interval(boolean isLeftInfinite, boolean isRightInfinite)
    {
        this.isInfinite = isLeftInfinite && isRightInfinite;
        this.isLeftInfinite = isLeftInfinite;
        this.isRightInfinite = isRightInfinite;

        if(isInfinite)
        {
            this.leftEndpoint = ANumber.ofMin();
            this.rightEndpoint = ANumber.ofMax();
        }
        else if(isLeftInfinite && !isRightInfinite)
        {
            this.leftEndpoint = ANumber.ofMin();
            this.rightEndpoint = ANumber.of(0);
            this.rightClosed = true;
        }
        else if(!isLeftInfinite && isRightInfinite)
        {
            this.leftEndpoint = ANumber.of(0);
            this.rightEndpoint = ANumber.ofMax();
            this.leftClosed = true;
        }
        else
        {
            this.isEmpty = true;
        }

    }


    public Interval(ANumber leftEndpoint, ANumber rightEndpoint, boolean leftClosed, boolean rightClosed)
    {
        IntervalRules.isValid(leftEndpoint, rightEndpoint);
        this.leftEndpoint = leftEndpoint;
        this.rightEndpoint = rightEndpoint;
        this.leftClosed = leftClosed;
        this.rightClosed = rightClosed;
    }


    public Interval(Number leftEndpoint, Number rightEndpoint, boolean leftClosed, boolean rightClosed)
    {
        IntervalRules.isValid(leftEndpoint, rightEndpoint);
        this.leftEndpoint = ANumber.of(leftEndpoint);
        this.rightEndpoint = ANumber.of(rightEndpoint);
        this.leftClosed = leftClosed;
        this.rightClosed = rightClosed;
    }


    public Interval(ANumber leftEndpoint, ANumber rightEndpoint)
    {
        IntervalRules.isLessThan(leftEndpoint, rightEndpoint);
        this.leftEndpoint = leftEndpoint;
        this.rightEndpoint = rightEndpoint;
        this.leftClosed = true;
        this.rightClosed = true;
    }


    public Interval(Number leftEndpoint, Number rightEndpoint)
    {
        IntervalRules.isLessThan(leftEndpoint, rightEndpoint);
        this.leftEndpoint = ANumber.of(leftEndpoint);
        this.rightEndpoint = ANumber.of(rightEndpoint);
        this.leftClosed = true;
        this.rightClosed = true;
    }


    public static Interval of()
    {
        return new Interval();
    }


    public static Interval of(ANumber leftEndpoint, ANumber rightEndpoint, boolean leftClosed, boolean rightClosed)
    {
        return new Interval(leftEndpoint, rightEndpoint, leftClosed, rightClosed);
    }


    public static Interval of(Number leftEndpoint, Number rightEndpoint, boolean leftClosed, boolean rightClosed)
    {
        return new Interval(leftEndpoint, rightEndpoint, leftClosed, rightClosed);
    }


    public static Interval of(ANumber leftEndpoint, ANumber rightEndpoint)
    {
        return new Interval(leftEndpoint, rightEndpoint);
    }


    public static Interval of(Number leftEndpoint, Number rightEndpoint)
    {
        return new Interval(leftEndpoint, rightEndpoint);
    }


    public static Interval ofInfinite()
    {
        return new Interval(true);
    }


    public static Interval ofLeftInfinite(ANumber rightEndpoint)
    {
        Interval temp = new Interval();
        IntervalRules.isValid(ANumber.ofMin(), rightEndpoint);
        temp.isLeftInfinite = true;
        temp.leftEndpoint = ANumber.ofMin();
        temp.rightEndpoint = rightEndpoint;
        temp.rightClosed = true;
        return temp;
    }


    public static Interval ofRightInfinite(ANumber leftEndpoint)
    {
        Interval temp = new Interval();
        IntervalRules.isValid(leftEndpoint, ANumber.ofMax());
        temp.isRightInfinite = true;
        temp.leftEndpoint = leftEndpoint;
        temp.rightEndpoint = ANumber.ofMax();
        temp.leftClosed = true;
        return temp;
    }


    public ANumber[] getAsArray()
    {
        return getAsArray(100);
    }


    public ANumber[] getAsArray(int numberOfValuesToUse)
    {
        return IntervalService.getAsArray(this, numberOfValuesToUse);
    }


    public ANumber getLength()
    {
        return rightEndpoint.subtractGET(leftEndpoint);
    }


    public ANumber getLengthOfEachOfNSubintervals(int n)
    {
        return getLength().divideGET(n);
    }


    public ANumber getSumOfEndpoints()
    {
        return rightEndpoint.addGET(leftEndpoint);
    }


    public Pair<Interval, Interval> splitInHalf()
    {
        return IntervalService.splitInHalf(this);
    }


    public Interval[] splitInN(int n)
    {
        return IntervalService.splitInN(this, n);
    }


    public ANumber getMidpoint()
    {
        return IntervalService.getMidpoint(this);
    }


    public boolean isPointInsideInterval(ANumber x)
    {
        return IntervalService.isPointInsideInterval(this, x);
    }


    public boolean isPointInsideInterval(Number x)
    {
        return isPointInsideInterval(ANumber.of(x));
    }


    public boolean isPointOutsideInterval(ANumber x)
    {
        return IntervalService.isPointOutsideInterval(this, x);
    }


    public boolean isPointOutsideInterval(Number x)
    {
        return isPointOutsideInterval(ANumber.of(x));
    }


    public boolean isIntervalInside(Interval other)
    {
        return IntervalService.isIntervalInside(this, other);
    }


    public boolean isIntervalOutside(Interval other)
    {
        return IntervalService.isIntervalOutside(this, other);
    }


    public Interval getIntersection(Interval other)
    {
        return IntervalService.getIntersection(this, other);
    }


    public Interval add(Interval other)
    {
        return IntervalService.add(this, other);
    }


    public Interval subtract(Interval other)
    {
        return IntervalService.subtract(this, other);
    }


    public Interval multiply(Interval other)
    {
        return IntervalService.multiply(this, other);
    }


    public Interval divide(Interval other)
    {
        return IntervalService.divide(this, other);
    }


    public Interval reciprocate()
    {
        return IntervalService.reciprocate(this);
    }


    public boolean isOpen()
    {
        return !isLeftClosed() && !isRightClosed();
    }


    public boolean isClosed()
    {
        return isLeftClosed() && isRightClosed();
    }


    public boolean isLeftClosed()
    {
        return this.leftClosed;
    }


    public boolean isRightClosed()
    {
        return this.rightClosed;
    }


    public boolean isLeftOpen()
    {
        return !isLeftClosed();
    }


    public boolean isRightOpen()
    {
        return !isRightClosed();
    }


    public String print()
    {
        return IntervalService.print(this);
    }


    @Override
    public String toString()
    {
        return print();
    }


    @Override
    public Interval clone() throws CloneNotSupportedException
    {
        return (Interval)CloningService.clone(this);
    }


    public Interval getCopy()
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
    public int compareTo(Interval other)
    {
        return IntervalInternalService.compareTo(this, other);
    }


    @Override
    public int hashCode()
    {
        return IntervalInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return IntervalInternalService.equals(this, object);
    }


    public ANumber getLeftEndpoint()
    {
        return this.leftEndpoint;
    }


    public ANumber getLeftEndpointCopy()
    {
        return getLeftEndpoint().getCopy();
    }


    public ANumber getRightEndpoint()
    {
        return this.rightEndpoint;
    }


    public ANumber getRightEndpointCopy()
    {
        return getRightEndpoint().getCopy();
    }


    public boolean isEmpty()
    {
        return this.isEmpty;
    }


    public boolean isInfinite()
    {
        return this.isInfinite;
    }


    public boolean isLeftInfinite()
    {
        return this.isLeftInfinite;
    }


    public boolean isRightInfinite()
    {
        return this.isRightInfinite;
    }
}