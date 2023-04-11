package com.orion.analytics.log.error.tasks;

import com.orion.analytics.log.LogAnalyticsService;
import com.orion.analytics.log.error.model.AnalyticsErrorModel;
import com.orion.core.abstraction.Orion;
import com.orion.logger.model.OrionErrorLogModel;
import java.util.ArrayList;
import java.util.List;

public class ConvertErrorLogModelsToAnalyticsErrorModelTask extends Orion
{
    public static List<AnalyticsErrorModel> run(List<OrionErrorLogModel> models, int numberOfCharactersToReturnForEachError)
    {

        if(models != null && !models.isEmpty())
        {
            List<AnalyticsErrorModel> results = new ArrayList<>();

            for(OrionErrorLogModel model : models)
            {

                if(numberOfCharactersToReturnForEachError < 0)
                {
                    results.add(LogAnalyticsService.convertErrorLogModelToAnalyticsErrorModel(model));
                }
                else
                {
                    results.add(LogAnalyticsService.convertErrorLogModelToAnalyticsErrorModel(model, numberOfCharactersToReturnForEachError));
                }

            }

            return results;
        }
        else
        {
            return new ArrayList<AnalyticsErrorModel>();
        }

    }
}