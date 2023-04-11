package com.orion.analytics.log.error.tasks;

import com.orion.analytics.log.error.model.AnalyticsErrorModel;
import com.orion.core.abstraction.Orion;
import com.orion.logger.model.OrionErrorLogModel;

public class ConvertErrorLogModelToAnalyticsErrorModelTask extends Orion
{
    public static AnalyticsErrorModel run(OrionErrorLogModel model, int numberOfCharactersToReturnForEachError)
    {

        if(model != null)
        {
            String errorMessage = "";

            if(numberOfCharactersToReturnForEachError < 0
                            || numberOfCharactersToReturnForEachError > model.getErrorMessage().length())
            {
                errorMessage = model.getErrorMessage();
            }
            else if(numberOfCharactersToReturnForEachError > 0)
            {
                errorMessage = model.getErrorMessage().substring(0, numberOfCharactersToReturnForEachError);
            }

            return AnalyticsErrorModel.builder()
                            .isErrorLog(true)
                            .operationID(model.getOperationID())
                            .errorType(model.getErrorType())
                            .errorMessage(errorMessage)
                            .logDateTime(model.getLogDateTime())
                            .userID(model.getUserID())
                            .comment(model.getComment())
                            .lastUpdateDateTime(model.getLastUpdateDateTime())
                            .isBeingInvestigated(model.getIsBeingInvestigated())
                            .hasBeingInvestigated(model.getHasBeingInvestigated())
                            .isBeingIgnored(model.getIsBeingIgnored())
                            .build();
        }
        else
        {
            return null;
        }

    }
}