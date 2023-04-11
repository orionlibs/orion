package com.orion.admin.log.error;

import com.orion.analytics.log.LogAnalyticsService;
import com.orion.analytics.log.error.model.AnalyticsErrorModel;
import com.orion.core.abstraction.OrionService;
import com.orion.logger.LoggingService;
import java.util.List;

public class AdminLoggerService extends OrionService
{
    public static long getNumberOfErrorLogs()
    {
        return LoggingService.getNumberOfErrorLogs();
    }


    public static List<AnalyticsErrorModel> getErrorLogs()
    {
        return LogAnalyticsService.getErrors();
    }


    public static List<AnalyticsErrorModel> getErrorLogsThatHaveNotBeenInvestigated()
    {
        return LogAnalyticsService.getErrorsThatHaveNotBeenInvestigated();
    }


    public static List<AnalyticsErrorModel> getErrorLogsThatHaveNotBeenInvestigated(int numberOfCharactersToReturnForEachError)
    {
        return LogAnalyticsService.getErrorsThatHaveNotBeenInvestigated(numberOfCharactersToReturnForEachError);
    }


    public static List<AnalyticsErrorModel> getLogsByOperationID(String operationID)
    {
        return LogAnalyticsService.getLogsByOperationID(operationID);
    }


    public static List<AnalyticsErrorModel> getLogsByOperationIDInChronologicalOrder(String operationID)
    {
        return LogAnalyticsService.getLogsByOperationIDInChronologicalOrder(operationID);
    }


    public static List<AnalyticsErrorModel> getLogsByOperationIDInReverseChronologicalOrder(String operationID)
    {
        return LogAnalyticsService.getLogsByOperationIDInReverseChronologicalOrder(operationID);
    }
    /*
     * public static List<DateTime> getErrorDateTimes() { return
     * getErrors().stream() .map(model -> model.getErrorDateTime())
     * .collect(Collectors.toList()); }
     */
    /*
     * public static List<List<Long>> getErrorDatesAndNumberOfErrors() { return
     * GetUserLoginDatesAndNumberOfLoginsTask.run(getErrorDateTimes()); }
     */
}