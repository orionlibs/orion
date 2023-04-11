package com.orion.analytics.log;

import com.orion.analytics.log.error.model.AnalyticsErrorModel;
import com.orion.analytics.log.error.tasks.ConvertActionLogModelToAnalyticsErrorModelTask;
import com.orion.analytics.log.error.tasks.ConvertActionLogModelsToAnalyticsErrorModelTask;
import com.orion.analytics.log.error.tasks.ConvertErrorLogModelToAnalyticsErrorModelTask;
import com.orion.analytics.log.error.tasks.ConvertErrorLogModelsToAnalyticsErrorModelTask;
import com.orion.analytics.log.error.tasks.GetLogsByOperationIDTask;
import com.orion.core.abstraction.OrionService;
import com.orion.logger.LoggingService;
import com.orion.logger.model.OrionErrorLogModel;
import com.orion.logger.model.OrionUserAndSystemActionLogModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogAnalyticsService extends OrionService
{
    public static List<AnalyticsErrorModel> getErrorsThatHaveNotBeenInvestigated()
    {
        List<OrionErrorLogModel> results = LoggingService.getErrorLogsThatHaveNotBeenInvestigated();
        return LogAnalyticsService.convertErrorLogModelsToAnalyticsErrorModel(results);
    }


    public static List<AnalyticsErrorModel> getErrorsThatHaveNotBeenInvestigated(int numberOfCharactersToReturnForEachError)
    {
        List<OrionErrorLogModel> results = LoggingService.getErrorLogsThatHaveNotBeenInvestigated();
        return LogAnalyticsService.convertErrorLogModelsToAnalyticsErrorModel(results, numberOfCharactersToReturnForEachError);
    }


    public static List<AnalyticsErrorModel> getErrors()
    {
        List<OrionErrorLogModel> results = LoggingService.getErrorLogs();
        return LogAnalyticsService.convertErrorLogModelsToAnalyticsErrorModel(results);
    }


    public static AnalyticsErrorModel convertErrorLogModelToAnalyticsErrorModel(OrionErrorLogModel model)
    {
        return ConvertErrorLogModelToAnalyticsErrorModelTask.run(model, -1);
    }


    public static AnalyticsErrorModel convertErrorLogModelToAnalyticsErrorModel(OrionErrorLogModel model, int numberOfCharactersToReturnForEachError)
    {
        return ConvertErrorLogModelToAnalyticsErrorModelTask.run(model, numberOfCharactersToReturnForEachError);
    }


    public static List<AnalyticsErrorModel> convertErrorLogModelsToAnalyticsErrorModel(List<OrionErrorLogModel> models)
    {
        return ConvertErrorLogModelsToAnalyticsErrorModelTask.run(models, -1);
    }


    public static List<AnalyticsErrorModel> convertErrorLogModelsToAnalyticsErrorModel(List<OrionErrorLogModel> models, int numberOfCharactersToReturnForEachError)
    {
        return ConvertErrorLogModelsToAnalyticsErrorModelTask.run(models, numberOfCharactersToReturnForEachError);
    }


    public static AnalyticsErrorModel convertActionLogModelToAnalyticsErrorModel(OrionUserAndSystemActionLogModel model)
    {
        return ConvertActionLogModelToAnalyticsErrorModelTask.run(model);
    }


    public static List<AnalyticsErrorModel> convertActionLogModelsToAnalyticsErrorModel(List<OrionUserAndSystemActionLogModel> models)
    {
        return ConvertActionLogModelsToAnalyticsErrorModelTask.run(models);
    }


    public static List<AnalyticsErrorModel> getErrorLogsByOperationID(String operationID)
    {
        return GetLogsByOperationIDTask.run(operationID);
    }


    public static List<AnalyticsErrorModel> getLogsByOperationID(String operationID)
    {
        List<AnalyticsErrorModel> errorLogs = getErrorLogsByOperationID(operationID);
        List<OrionUserAndSystemActionLogModel> actionLogsTemp = LoggingService.getActionLogsByOperationID(operationID);
        List<AnalyticsErrorModel> actionLogs = convertActionLogModelsToAnalyticsErrorModel(actionLogsTemp);
        List<AnalyticsErrorModel> allLogs = new ArrayList<>(errorLogs);
        allLogs.addAll(actionLogs);
        return allLogs;
    }


    public static List<AnalyticsErrorModel> getLogsByOperationIDInChronologicalOrder(String operationID)
    {
        List<AnalyticsErrorModel> allLogs = getLogsByOperationID(operationID);
        Collections.sort(allLogs);
        return allLogs;
    }


    public static List<AnalyticsErrorModel> getLogsByOperationIDInReverseChronologicalOrder(String operationID)
    {
        List<AnalyticsErrorModel> allLogs = getLogsByOperationIDInChronologicalOrder(operationID);
        Collections.reverse(allLogs);
        return allLogs;
    }
}