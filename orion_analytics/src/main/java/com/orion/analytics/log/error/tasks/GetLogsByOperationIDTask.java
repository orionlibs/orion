package com.orion.analytics.log.error.tasks;

import com.orion.analytics.log.LogAnalyticsService;
import com.orion.analytics.log.error.model.AnalyticsErrorModel;
import com.orion.core.abstraction.Orion;
import com.orion.logger.LoggingService;
import com.orion.logger.model.OrionErrorLogModel;
import java.util.ArrayList;
import java.util.List;

public class GetLogsByOperationIDTask extends Orion
{
    public static List<AnalyticsErrorModel> run(String operationID)
    {
        List<AnalyticsErrorModel> models = new ArrayList<>();
        List<OrionErrorLogModel> results = LoggingService.getErrorLogsByOperationID(operationID);

        if(results != null && !results.isEmpty())
        {
            models = LogAnalyticsService.convertErrorLogModelsToAnalyticsErrorModel(results);
        }

        return models;
    }
}