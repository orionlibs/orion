package com.orion.analytics.user.authentication.tasks;

import com.orion.analytics.user.model.AnalyticsRegistrationModel;
import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.model.OrionUserModel;
import java.util.ArrayList;
import java.util.List;

public class GetUserRegistrationsDateTimesByAuthorityTask extends Orion
{
    public static List<AnalyticsRegistrationModel> run(String authority)
    {
        List<AnalyticsRegistrationModel> models = new ArrayList<>();
        List<OrionUserModel> results = UserAccountService.getUserRegistrationDateTimesByAuthority(authority);

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