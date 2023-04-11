package com.orion.analytics.user.authentication.tasks;

import com.orion.analytics.user.model.AnalyticsLoginModel;
import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.user_management.authentication.login.data_access.OrionUserLoginsDAO;
import com.orion.user_management.authentication.login.model.OrionUserLoginModel;
import java.util.ArrayList;
import java.util.List;

public class GetUserLoginsDateTimesForAuthorityTask extends Orion
{
    public static List<AnalyticsLoginModel> run(String authority)
    {
        List<AnalyticsLoginModel> models = new ArrayList<>();
        List<OrionUserLoginModel> results = OrionUserLoginsDAO.getDateTimesByAuthority(authority);

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