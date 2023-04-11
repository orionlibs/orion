package com.orion.analytics.log.error.tasks;

import com.orion.analytics.log.LogAnalyticsService;
import com.orion.analytics.log.error.model.AnalyticsErrorModel;
import com.orion.core.abstraction.Orion;
import com.orion.logger.model.OrionUserAndSystemActionLogModel;
import java.util.ArrayList;
import java.util.List;

public class ConvertActionLogModelsToAnalyticsErrorModelTask extends Orion
{
    public static List<AnalyticsErrorModel> run(List<OrionUserAndSystemActionLogModel> models)
    {

        if(models != null && !models.isEmpty())
        {
            List<AnalyticsErrorModel> results = new ArrayList<>();

            for(OrionUserAndSystemActionLogModel model : models)
            {
                results.add(LogAnalyticsService.convertActionLogModelToAnalyticsErrorModel(model));
            }

            return results;
        }
        else
        {
            return new ArrayList<AnalyticsErrorModel>();
        }

    }
}