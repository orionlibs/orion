package com.orion.math.sequence;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.series.partialsums.SeriesWithPartialSums;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Sequence implements MathObject, Cloneable
{
    private Function1x1IF<ANumber, ANumber> expression;
    private ANumber firstIndex;
    private ANumber lastIndex;


    public Sequence()
    {
    }


    public Sequence(Function1x1IF<ANumber, ANumber> expression)
    {
        FunctionRules.isValid(expression);
        this.expression = expression;
    }


    public Sequence(Function1x1IF<ANumber, ANumber> expression, ANumber firstIndex, ANumber lastIndex)
    {
        FunctionRules.isValid(expression);
        NumberRules.areAllPositive(firstIndex, lastIndex);
        NumberRules.isLessThanOrEqual(firstIndex, lastIndex);
        this.expression = expression;
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
    }


    public static Sequence of(Function1x1IF<ANumber, ANumber> expression)
    {
        return new Sequence(expression);
    }


    public static Sequence of(Function1x1IF<ANumber, ANumber> expression, ANumber firstIndex, ANumber lastIndex)
    {
        return new Sequence(expression, firstIndex, lastIndex);
    }


    public Sequence getSubsequence(ANumber newFirstIndex, ANumber newLastIndex)
    {
        NumberRules.areNotNull(firstIndex, lastIndex);
        NumberRules.isLessThanOrEqual(newFirstIndex, newLastIndex);
        NumberRules.isGreaterThanOrEqual(newFirstIndex, firstIndex);
        NumberRules.isLessThanOrEqual(newFirstIndex, lastIndex);
        Sequence copy = getCopy();
        copy.setFirstIndex(newFirstIndex);
        copy.setLastIndex(newLastIndex);
        return copy;
    }


    public Sequence getSubsequence(int newFirstIndex, int newLastIndex)
    {
        return getSubsequence(ANumber.of(newFirstIndex), ANumber.of(newLastIndex));
    }


    public List<ANumber> getFirstNTerms(ANumber n)
    {
        NumberRules.isPositive(n);
        List<ANumber> terms = new ArrayList<ANumber>();

        for(int i = 1; i <= n.getAsInt(); i++)
        {
            terms.add(getExpression().run(ANumber.of(i)));
        }

        return terms;
    }


    public List<ANumber> getFirstNTerms(int n)
    {
        return getFirstNTerms(ANumber.of(n));
    }


    public ANumber getNthTerm(ANumber n)
    {
        List<ANumber> terms = getFirstNTerms(n);
        return terms.get(terms.size() - 1);
    }


    public ANumber getNthTerm(int n)
    {
        return getNthTerm(ANumber.of(n));
    }


    public ANumber getTermIndex(ANumber term)
    {

        for(long i = 1; i < Long.MAX_VALUE; i++)
        {

            if(getExpression().run(ANumber.of(i)).equal(term))
            {
                return ANumber.of(i);
            }

        }

        return ANumber.of(-1);
    }


    public ANumber getTermIndex(int term)
    {
        return getTermIndex(ANumber.of(term));
    }


    public ANumber getSumOfFirstNTerms(ANumber n)
    {
        return SeriesWithPartialSums.of(expression).getSum(ANumber.of(1), n);
    }


    public ANumber getSumOfFirstNTerms(int n)
    {
        return getSumOfFirstNTerms(ANumber.of(n));
    }


    public ANumber getBackwardsDifferenceForNthTerm(ANumber n)
    {
        return getNthTerm(n).subtractGET(getNthTerm(n.subtractOneGET()));
    }


    public ANumber getBackwardsDifferenceForNthTerm(int n)
    {
        return getBackwardsDifferenceForNthTerm(ANumber.of(n));
    }


    public ANumber getForwardsDifferenceForNthTerm(ANumber n)
    {
        return getNthTerm(n.addOneGET()).subtractGET(getNthTerm(n.addOneGET()));
    }


    public ANumber getForwardsDifferenceForNthTerm(int n)
    {
        return getForwardsDifferenceForNthTerm(ANumber.of(n));
    }


    public boolean isArithmeticSequenceBasedOnFirstNTerms(int n)
    {
        List<ANumber> differences = getDifferenceSequenceForFirstNTerms(n);
        ANumber difference = differences.get(0);
        return !differences.stream().anyMatch(diff -> diff.notEqual(difference));
    }


    public List<ANumber> getDifferenceSequenceForFirstNTerms(int n)
    {
        List<ANumber> terms = getFirstNTerms(n);
        List<ANumber> differences = new ArrayList<>();
        terms.forEach(term -> differences.add(getForwardsDifferenceForNthTerm(term)));
        return differences;
    }


    public List<ANumber> getDifferenceSequenceOdDegreeMForFirstNTerms(int n, int m)
    {
        NumberRules.isGreaterThan(m, 0);
        Vector[] differences = new Vector[]
        {Vector.of(getFirstNTerms(n))};
        IntStream.range(1, m + 1).forEach(i -> differences[0] = differences[0].getDifferencesBetweenSuccessiveElements());
        return differences[0].getAsList();
    }


    @Override
    public Sequence clone() throws CloneNotSupportedException
    {
        return (Sequence)CloningService.clone(this);
    }


    public Sequence getCopy()
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


    public Function1x1IF<ANumber, ANumber> getExpression()
    {
        return this.expression;
    }


    protected void setExpression(Function1x1IF<ANumber, ANumber> expression)
    {
        this.expression = expression;
    }


    public ANumber getFirstIndex()
    {
        return this.firstIndex;
    }


    protected void setFirstIndex(ANumber firstIndex)
    {
        this.firstIndex = firstIndex;
    }


    public ANumber getLastIndex()
    {
        return this.lastIndex;
    }


    protected void setLastIndex(ANumber lastIndex)
    {
        this.lastIndex = lastIndex;
    }
}