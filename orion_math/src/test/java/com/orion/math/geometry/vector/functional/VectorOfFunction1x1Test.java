package com.orion.math.geometry.vector.functional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class VectorOfFunction1x1Test
{
    @Test
    public void add()
    {
        List<Function1x1<ANumber, ANumber>> elements = new ArrayList<>();
        elements.add(Function1x1.<ANumber, ANumber>of(x -> x.squareGET()));
        elements.add(Function1x1.<ANumber, ANumber>of(x -> x.doubleGET()));
        elements.add(Function1x1.<ANumber, ANumber>of(x -> x.doubleGET().addGET(4)));
        VectorOfFunction1x1 v = VectorOfFunction1x1.of(elements);
        VectorOfFunction1x1 result = v.add(ANumber.of(3));
        assertTrue(ANumber.of(7).equal(result.get(0).run(ANumber.of(2))));
        assertTrue(ANumber.of(7).equal(result.get(1).run(ANumber.of(2))));
        assertTrue(ANumber.of(11).equal(result.get(2).run(ANumber.of(2))));
    }
}