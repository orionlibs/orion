package com.orion.core.calendar.tasks.format;

import com.orion.core.abstraction.Orion;

public class GetFormattedDurationInHoursAndMinutesTask extends Orion
{
    public static String run(int numberOfMinutes)
    {
        String formattedDuration = "";

        if(numberOfMinutes < 60)
        {
            formattedDuration = Integer.toString(numberOfMinutes) + " minutes";
        }
        else
        {
            int numberOfHours = numberOfMinutes / 60;
            int numberOfMinutesTemp = numberOfMinutes - (numberOfHours * 60);
            formattedDuration = Integer.toString(numberOfHours) + " hours";

            if(numberOfMinutesTemp != 0)
            {
                formattedDuration += " + " + Integer.toString(numberOfMinutesTemp) + " minutes";
            }

        }

        return formattedDuration;
    }
}