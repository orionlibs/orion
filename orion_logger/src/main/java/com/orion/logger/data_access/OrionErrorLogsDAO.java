package com.orion.logger.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.logger.model.LoggerDatabaseModel;
import com.orion.logger.model.OrionErrorLogModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrionErrorLogsDAO extends OrionDAO
{
    public static long getNumberOfErrorLogs()
    {
        return Database.getNumberOfRecords(LoggerDatabaseModel.tableErrorLogs,
                        Database.logsDatabaseName);
    }


    public static List<OrionErrorLogModel> getErrorLogs()
    {
        List<OrionErrorLogModel> errorLogs = new ArrayList<>();
        List<Object> temp = Database.getAllRows(OrionErrorLogModel.of(),
                        LoggerDatabaseModel.tableErrorLogs,
                        Database.logsDatabaseName);

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(errorLog -> errorLogs.add((OrionErrorLogModel)errorLog));
        }

        return errorLogs;
    }


    public static List<OrionErrorLogModel> getErrorLogsThatHaveNotBeenInvestigated()
    {
        OrionErrorLogModel model = OrionErrorLogModel.builder()
                        .hasBeingInvestigated(Boolean.FALSE)
                        .build();
        List<Object> temp = Database.getModels(model,
                        LoggerDatabaseModel.tableErrorLogs,
                        Database.logsDatabaseName,
                        Arrays.asList(LoggerDatabaseModel.hasBeingInvestigated));
        List<OrionErrorLogModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionErrorLogModel)model1));
        }

        return results;
    }


    public static List<OrionErrorLogModel> getErrorLogsByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionErrorLogModel model = OrionErrorLogModel.of(userID);
        List<Object> temp = Database.getModels(model,
                        LoggerDatabaseModel.tableErrorLogs,
                        Database.logsDatabaseName,
                        Arrays.asList(LoggerDatabaseModel.userID));
        List<OrionErrorLogModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionErrorLogModel)model1));
        }

        return results;
    }


    public static List<OrionErrorLogModel> getErrorLogsByOperationID(String operationID)
    {
        Assert.notEmpty(operationID, "The given operationID is null/empty.");
        OrionErrorLogModel model = OrionErrorLogModel.builder()
                        .operationID(operationID)
                        .build();
        List<Object> temp = Database.getModels(model,
                        LoggerDatabaseModel.tableErrorLogs,
                        Database.logsDatabaseName,
                        Arrays.asList(LoggerDatabaseModel.operationID));
        List<OrionErrorLogModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionErrorLogModel)model1));
        }

        return results;
    }


    public static long getNumberOfErrorLogsByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionErrorLogModel model = OrionErrorLogModel.of(userID);
        return Database.getNumberOfRecords(model,
                        LoggerDatabaseModel.tableErrorLogs,
                        Database.logsDatabaseName,
                        Arrays.asList(LoggerDatabaseModel.userID));
    }


    public static long getNumberOfErrorLogsByOperationID(String operationID)
    {
        Assert.notEmpty(operationID, "The given operationID is null/empty.");
        OrionErrorLogModel model = OrionErrorLogModel.builder()
                        .operationID(operationID)
                        .build();
        return Database.getNumberOfRecords(model,
                        LoggerDatabaseModel.tableErrorLogs,
                        Database.logsDatabaseName,
                        Arrays.asList(LoggerDatabaseModel.operationID));
    }


    public static long getNumberOfErrorLogsByUserIDAndDate(String userID, String date)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        Assert.notEmpty(date, "The given date is null/empty.");
        OrionErrorLogModel model = OrionErrorLogModel.builder()
                        .userID(userID)
                        .logDate(date)
                        .build();
        return Database.getNumberOfRecords(model,
                        LoggerDatabaseModel.tableErrorLogs,
                        Database.logsDatabaseName,
                        Arrays.asList(LoggerDatabaseModel.userID,
                                        LoggerDatabaseModel.logDate));
    }


    public static int save(OrionErrorLogModel model)
    {
        return Database.saveModel(model,
                        LoggerDatabaseModel.tableErrorLogs,
                        Database.logsDatabaseName);
    }


    public static int update(OrionErrorLogModel model)
    {
        Assert.notNull(model, "The given OrionErrorLogModel is null.");
        return Database.updateModel(model,
                        LoggerDatabaseModel.tableErrorLogs,
                        Database.logsDatabaseName,
                        Arrays.asList(LoggerDatabaseModel.errorLogID));
    }
}