package com.orion.analytics.user.authentication.tasks;

import com.orion.analytics.user.model.AnalyticsLogoutModel;
import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.date.Date;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.user_management.authentication.logout.data_access.OrionUserLogoutsDAO;
import com.orion.user_management.authentication.logout.model.OrionUserLogoutModel;
import java.util.ArrayList;
import java.util.List;

public class GetUserLogoutsDateTimesOfUserIDForDateRangeTask extends Orion
{
    public static List<AnalyticsLogoutModel> run(String userID, String startDate, String endDate) throws InvalidDateException
    {
        List<AnalyticsLogoutModel> models = new ArrayList<>();
        Date date1 = Date.of(startDate);
        Date date2 = Date.of(endDate);
        List<Date> dates = new ArrayList<>();
        dates.add(date1);
        dates.add(date2);
        List<Date> sortedDates = CalendarService.sortDates(dates);
        String date1String = sortedDates.get(0).getDateStringSplitByHyphensYearFirst();
        String date2String = sortedDates.get(1).getDateStringSplitByHyphensYearFirst();
        List<OrionUserLogoutModel> results = OrionUserLogoutsDAO.getDateTimesByUserIDForDateRange(userID, date1String, date2String);

        if(results != null && !results.isEmpty())
        {

            for(OrionUserLogoutModel model : results)
            {
                AnalyticsLogoutModel analyticsLogoutModel = AnalyticsLogoutModel.builder()
                                .logoutDateTime(DateTime.of(model.getLogoutDateTime()))
                                .build();
                models.add(analyticsLogoutModel);
            }

        }

        return models;
    }
}