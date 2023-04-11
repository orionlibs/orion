package com.orion.math.number.interval.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;

public class GetIntervalAsArrayTask extends Orion
{
    public static ANumber[] run(Interval x, int numberOfValuesToUse)
    {
        ANumber[] values = new ANumber[numberOfValuesToUse];
        ANumber length = x.getLength();
        ANumber step = length.divideGET(numberOfValuesToUse);

        for(int i = 0; i < numberOfValuesToUse; i++)
        {

            if(i == numberOfValuesToUse - 1)
            {
                values[i] = x.getRightEndpointCopy();
            }
            else
            {
                values[i] = x.getLeftEndpoint().addGET(step.multiplyGET(i));
            }

        }

        return values;
    }
}