package com.orion.logger.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.logger.model.LoggerDatabaseModel;
import com.orion.logger.model.OrionUserAndSystemActionLogModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrionUserAndSystemActionLogsDAO extends OrionDAO
{
    public static long getNumberOfLogs()
    {
        return Database.getNumberOfRecords(LoggerDatabaseModel.tableUserAndSystemActionsLogs,
                        Database.logsDatabaseName);
    }


    public static List<OrionUserAndSystemActionLogModel> getLogsByOperationID(String operationID)
    {
        Assert.notEmpty(operationID, "The given operationID is null/empty.");
        OrionUserAndSystemActionLogModel model = OrionUserAndSystemActionLogModel.builder()
                        .operationID(operationID)
                        .build();
        List<Object> temp = Database.getModels(model,
                        LoggerDatabaseModel.tableUserAndSystemActionsLogs,
                        Database.logsDatabaseName,
                        Arrays.asList(LoggerDatabaseModel.operationID));
        List<OrionUserAndSystemActionLogModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserAndSystemActionLogModel)model1));
        }

        return results;
    }


    public static List<OrionUserAndSystemActionLogModel> getLogs()
    {
        List<OrionUserAndSystemActionLogModel> results = new ArrayList<>();
        List<Object> temp = Database.getAllRows(OrionUserAndSystemActionLogModel.of(),
                        LoggerDatabaseModel.tableUserAndSystemActionsLogs,
                        Database.logsDatabaseName);

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(type -> results.add((OrionUserAndSystemActionLogModel)type));
        }

        return results;
    }


    public static int saveLog(OrionUserAndSystemActionLogModel model)
    {
        return Database.saveModel(model,
                        LoggerDatabaseModel.tableUserAndSystemActionsLogs,
                        Database.logsDatabaseName);
    }


    public static int updateLog(OrionUserAndSystemActionLogModel model)
    {
        return Database.updateModel(model,
                        LoggerDatabaseModel.tableUserAndSystemActionsLogs,
                        Database.logsDatabaseName,
                        Arrays.asList(LoggerDatabaseModel.userAndSystemActionLogID));
    }
}