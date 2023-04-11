package com.orion.analytics.user.authentication.tasks;

import com.orion.analytics.user.model.AnalyticsRegistrationModel;
import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.date.Date;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.model.OrionUserModel;
import java.util.ArrayList;
import java.util.List;

public class GetUserRegistrationsDateTimesForDateRangeTask extends Orion
{
    public static List<AnalyticsRegistrationModel> run(String startDate, String endDate) throws InvalidDateException
    {
        List<AnalyticsRegistrationModel> models = new ArrayList<>();
        Date date1 = Date.of(startDate);
        Date date2 = Date.of(endDate);
        List<Date> dates = new ArrayList<>();
        dates.add(date1);
        dates.add(date2);
        List<Date> sortedDates = CalendarService.sortDates(dates);
        String date1String = sortedDates.get(0).getDateStringSplitByHyphensYearFirst();
        String date2String = sortedDates.get(1).getDateStringSplitByHyphensYearFirst();
        List<OrionUserModel> results = UserAccountService.getUserRegistrationDateTimesForDateRange(date1String, date2String);

        if(results != null && !results.isEmpty())
        {

            for(OrionUserModel model : results)
            {
                AnalyticsRegistrationModel analyticsRegistrationModel = AnalyticsRegistrationModel.builder()
                                .registrationDateTime(DateTime.of(model.getRegistrationDateTime()))
                                .build();
                models.add(analyticsRegistrationModel);
            }

        }

        return models;
    }
}