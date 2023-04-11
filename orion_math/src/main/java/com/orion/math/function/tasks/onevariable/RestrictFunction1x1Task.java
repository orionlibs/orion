package com.orion.math.function.tasks.onevariable;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.domain.FunctionDomain1x1;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class RestrictFunction1x1Task extends Orion
{
    public static Function1x1<Object, Object> run(Function1x1<Object, Object> f, Interval newIntervalOfX)
    {
        FunctionRules.isValid(f);
        IntervalRules.isValid(newIntervalOfX);

        if(f.getDomain() != null && f.getDomain().getIntervalOfVariable1() != null)
        {

            if(f.getDomain().getIntervalOfVariable1().isIntervalInside(newIntervalOfX))
            {
                return Function1x1.<Object, Object>of(f.getFunctionCasted(), FunctionDomain1x1.of(newIntervalOfX), f.getCodomain());
            }
            else
            {
                throw new InvalidArgumentException("The given newIntervalOfX is not inside/included the domain's interval.");
            }

        }
        else
        {
            throw new InvalidArgumentException("The domain's interval is null and it is needed to determine if the given newIntervalOfX is actually a restriction.");
        }

    }
}