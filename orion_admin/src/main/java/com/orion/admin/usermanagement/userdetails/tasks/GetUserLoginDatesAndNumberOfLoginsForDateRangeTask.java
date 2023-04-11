package com.orion.admin.usermanagement.userdetails.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.user_management.authentication.login.data_access.OrionUserLoginsDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetUserLoginDatesAndNumberOfLoginsForDateRangeTask extends Orion
{
    public static List<List<Long>> run(List<DateTime> loginDateTimes)
    {
        List<DateTime> sortedLoginDateTimes = CalendarService.sortDateTimes(loginDateTimes);
        List<List<Long>> loginDatesToNumberOfLogins = new ArrayList<List<Long>>();

        for(DateTime datetime : sortedLoginDateTimes)
        {
            long numberOfLoginsForDate = OrionUserLoginsDAO.getNumberOfLoginsByDate(datetime.getDate().getDateStringSplitByHyphensYearFirst());
            loginDatesToNumberOfLogins.add(Arrays.asList(CalendarService.convertDateTimeToEpochMilliseconds(datetime), numberOfLoginsForDate));
        }

        return loginDatesToNumberOfLogins;
    }
}