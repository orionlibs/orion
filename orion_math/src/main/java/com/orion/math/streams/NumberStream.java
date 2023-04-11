package com.orion.math.streams;

import com.orion.math.MathObject;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberStream implements MathObject
{
    private Stream<ANumber> stream;


    public NumberStream()
    {
    }


    public NumberStream(Stream<ANumber> stream)
    {
        this.stream = stream;
    }


    public NumberStream(ANumber startInclusive, ANumber endInclusive)
    {
        NumberRules.areNotNull(startInclusive, endInclusive);

        if(startInclusive.isLessThan(endInclusive))
        {
            List<ANumber> iterationIndices = new ArrayList<ANumber>();

            for(ANumber i = startInclusive.getCopy(); i.isLessThanOrEqual(endInclusive); i = i.addOneGET())
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


    public NumberStream(Number startInclusive, ANumber endInclusive)
    {
        this(ANumber.of(startInclusive), endInclusive);
    }


    public NumberStream(ANumber startInclusive, Number endInclusive)
    {
        this(startInclusive, ANumber.of(endInclusive));
    }


    public NumberStream(Number startInclusive, Number endInclusive)
    {
        this(ANumber.of(startInclusive), ANumber.of(endInclusive));
    }


    public static NumberStream of(ANumber startInclusive, ANumber endInclusive)
    {
        NumberRules.areNotNull(startInclusive, endInclusive);

        if(startInclusive.isGreaterThanOrEqual(endInclusive))
        {
            throw new IllegalArgumentException("startInclusive cannot be >= endInclusive.");
        }
        else
        {
            return new NumberStream(startInclusive, endInclusive);
        }

    }


    public static NumberStream of(Number startInclusive, ANumber endInclusive)
    {
        return new NumberStream(startInclusive, endInclusive);
    }


    public static NumberStream of(ANumber startInclusive, Number endInclusive)
    {
        return new NumberStream(startInclusive, endInclusive);
    }


    public static NumberStream of(Number startInclusive, Number endInclusive)
    {
        return new NumberStream(startInclusive, endInclusive);
    }


    public static NumberStream of(Stream<ANumber> stream)
    {
        return new NumberStream(stream);
    }


    public NumberStream filter(Predicate<ANumber> predicate)
    {
        return NumberStream.of(stream.filter(predicate));
    }


    public void forAll(Consumer<ANumber> action)
    {
        stream.forEach(action);
    }


    public List<ANumber> getAsList()
    {
        return stream.collect(Collectors.toList());
    }
}