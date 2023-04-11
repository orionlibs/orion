package com.orion.analytics.user.authentication.tasks;

import com.orion.analytics.user.model.AnalyticsLogoutModel;
import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.user_management.authentication.logout.data_access.OrionUserLogoutsDAO;
import com.orion.user_management.authentication.logout.model.OrionUserLogoutModel;
import java.util.ArrayList;
import java.util.List;

public class GetUserLogoutsDateTimesTask extends Orion
{
    public static List<AnalyticsLogoutModel> run(String userID)
    {
        List<AnalyticsLogoutModel> models = new ArrayList<>();
        List<OrionUserLogoutModel> results = OrionUserLogoutsDAO.getDateTimesByUserID(userID);

        if(results != null && !results.isEmpty())
        {

            for(OrionUserLogoutModel model : results)
            {
                models.add(AnalyticsLogoutModel.builder()
                                .logoutDateTime(DateTime.of(model.getLogoutDateTime()))
                                .build());
            }

        }

        return models;
    }
}