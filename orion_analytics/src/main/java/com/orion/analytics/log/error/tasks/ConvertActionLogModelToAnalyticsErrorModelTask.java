package com.orion.analytics.log.error.tasks;

import com.orion.analytics.log.error.model.AnalyticsErrorModel;
import com.orion.core.abstraction.Orion;
import com.orion.logger.model.OrionUserAndSystemActionLogModel;

public class ConvertActionLogModelToAnalyticsErrorModelTask extends Orion
{
    public static AnalyticsErrorModel run(OrionUserAndSystemActionLogModel model)
    {

        if(model != null)
        {
            return AnalyticsErrorModel.builder()
                            .isErrorLog(false)
                            .operationID(model.getOperationID())
                            .logDateTime(model.getLogDateTime())
                            .userID(model.getUserID())
                            .actorType(model.getActionType())
                            .actionType(model.getActionType())
                            .IPAddress(model.getIPAddress())
                            .actionDescription(model.getActionDescription())
                            .build();
        }
        else
        {
            return null;
        }

    }
}