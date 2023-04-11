package com.orion.analytics.user.authentication.tasks;

import com.orion.analytics.user.model.AnalyticsLoginModel;
import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.date.Date;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.user_management.authentication.login.data_access.OrionUserLoginsDAO;
import com.orion.user_management.authentication.login.model.OrionUserLoginModel;
import java.util.ArrayList;
import java.util.List;

public class GetUserLoginsDateTimesOfUserIDForDateRangeTask extends Orion
{
    public static List<AnalyticsLoginModel> run(String userID, String startDate, String endDate) throws InvalidDateException
    {
        List<AnalyticsLoginModel> models = new ArrayList<>();
        Date date1 = Date.of(startDate);
        Date date2 = Date.of(endDate);
        List<Date> dates = new ArrayList<>();
        dates.add(date1);
        dates.add(date2);
        List<Date> sortedDates = CalendarService.sortDates(dates);
        String date1String = sortedDates.get(0).getDateStringSplitByHyphensYearFirst();
        String date2String = sortedDates.get(1).getDateStringSplitByHyphensYearFirst();
        List<OrionUserLoginModel> results = OrionUserLoginsDAO.getDateTimesByUserIDForDateRange(userID, date1String, date2String);

        if(results != null && !results.isEmpty())
        {

            for(OrionUserLoginModel model : results)
            {
                AnalyticsLoginModel analyticsLoginModel = AnalyticsLoginModel.builder()
                                .loginDateTime(DateTime.of(model.getLoginDateTime()))
                                .build();
                models.add(analyticsLoginModel);
            }

        }

        return models;
    }
}