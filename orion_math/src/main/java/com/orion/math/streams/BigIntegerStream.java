package com.orion.math.streams;

import com.orion.math.MathObject;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BigIntegerStream implements MathObject
{
    private Stream<BigInteger> stream;


    public BigIntegerStream()
    {
    }


    public BigIntegerStream(Stream<BigInteger> stream)
    {
        this.stream = stream;
    }


    public BigIntegerStream(BigInteger startInclusive, BigInteger endInclusive)
    {
        NumberRules.areNotNull(startInclusive, endInclusive);

        if(startInclusive.compareTo(endInclusive) == 0)
        {
            List<BigInteger> iterationIndices = new ArrayList<BigInteger>();

            for(BigInteger i = startInclusive; Numbers.isLessThanOrEqual(i, endInclusive); i = i.add(BigInteger.ONE))
            {
                iterationIndices.add(i);
            }

            this.stream = iterationIndices.stream();
        }
        else
        {
            this.stream = Stream.empty();
        }

    }


    public static BigIntegerStream of(BigInteger startInclusive, BigInteger endInclusive)
    {
        NumberRules.areNotNull(startInclusive, endInclusive);

        if(startInclusive.compareTo(endInclusive) > 0)
        {
            throw new IllegalArgumentException("startInclusive cannot be >= endInclusive.");
        }
        else
        {
            return new BigIntegerStream(startInclusive, endInclusive);
        }

    }


    public static BigIntegerStream of(Stream<BigInteger> stream)
    {
        return new BigIntegerStream(stream);
    }


    public BigIntegerStream filter(Predicate<BigInteger> predicate)
    {
        return BigIntegerStream.of(stream.filter(predicate));
    }


    public void forAll(Consumer<BigInteger> action)
    {
        stream.forEach(action);
    }


    public List<BigInteger> getAsList()
    {
        return stream.collect(Collectors.toList());
    }
}