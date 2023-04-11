package com.orion.math.variable;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class NumberVariableTest
{
    @Test
    public void numberVariable()
    {
        NumberVariable var = NumberVariable.of();
        Function1x1IF<NumberVariable, ANumber> func1 = (x -> x.run(4));
        Function1x1<NumberVariable, ANumber> f1 = Function1x1.of(func1);
        Function1x1IF<NumberVariable, Function1x1<ANumber, ANumber>> func2 = (x -> x.getFunction().add(x.getFunction()));
        Function1x1<NumberVariable, Function1x1<ANumber, ANumber>> f2 = Function1x1.of(func2);
        assertTrue(ANumber.of(4).equal(f1.run(var)));
        System.out.println(f2.run(var).run(ANumber.of(4)));
        assertTrue(ANumber.of(8).equal(f2.run(var).run(ANumber.of(4))));
    }
}