package com.orion.admin.usermanagement.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.user_management.account.UserAccountService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetUserRegistrationDatesAndNumberOfRegistrationsTask extends Orion
{
    public static List<List<Long>> run(List<DateTime> registrationDateTimes)
    {
        List<DateTime> sortedRegistrationDateTimes = CalendarService.sortDateTimes(registrationDateTimes);
        List<List<Long>> registrationDatesToNumberOfRegistrations = new ArrayList<List<Long>>();

        for(DateTime datetime : sortedRegistrationDateTimes)
        {
            long numberOfRegistrationsForDate = UserAccountService.getNumberOfUserRegistrationsByDate(datetime.getDate().getDateStringSplitByHyphensYearFirst());
            registrationDatesToNumberOfRegistrations.add(Arrays.asList(CalendarService.convertDateTimeToEpochMilliseconds(datetime), numberOfRegistrationsForDate));
        }

        return registrationDatesToNumberOfRegistrations;
    }
}