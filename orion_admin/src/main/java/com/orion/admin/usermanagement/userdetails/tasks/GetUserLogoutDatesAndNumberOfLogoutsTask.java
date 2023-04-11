package com.orion.admin.usermanagement.userdetails.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.user_management.authentication.logout.data_access.OrionUserLogoutsDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetUserLogoutDatesAndNumberOfLogoutsTask extends Orion
{
    public static List<List<Long>> run(String userID, List<DateTime> logoutDateTimes)
    {
        List<DateTime> sortedLogoutDateTimes = CalendarService.sortDateTimes(logoutDateTimes);
        List<List<Long>> logoutDatesToNumberOfLogouts = new ArrayList<List<Long>>();

        for(DateTime datetime : sortedLogoutDateTimes)
        {
            long numberOfLogoutsForDate = OrionUserLogoutsDAO.getNumberOfLogoutsByUserIDAndDate(userID, datetime.getDate().getDateStringSplitByHyphensYearFirst());
            logoutDatesToNumberOfLogouts.add(Arrays.asList(CalendarService.convertDateTimeToEpochMilliseconds(datetime), numberOfLogoutsForDate));
        }

        return logoutDatesToNumberOfLogouts;
    }
}