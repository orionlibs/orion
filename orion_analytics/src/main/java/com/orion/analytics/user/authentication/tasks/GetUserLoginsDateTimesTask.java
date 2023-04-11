package com.orion.analytics.user.authentication.tasks;

import com.orion.analytics.user.model.AnalyticsLoginModel;
import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.user_management.authentication.login.data_access.OrionUserLoginsDAO;
import com.orion.user_management.authentication.login.model.OrionUserLoginModel;
import java.util.ArrayList;
import java.util.List;

public class GetUserLoginsDateTimesTask extends Orion
{
    public static List<AnalyticsLoginModel> run(String userID)
    {
        List<AnalyticsLoginModel> models = new ArrayList<>();
        List<OrionUserLoginModel> results = OrionUserLoginsDAO.getDateTimesByUserID(userID);

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


    public static List<AnalyticsLoginModel> run()
    {
        List<AnalyticsLoginModel> models = new ArrayList<>();
        List<OrionUserLoginModel> results = OrionUserLoginsDAO.getUserLogins();

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