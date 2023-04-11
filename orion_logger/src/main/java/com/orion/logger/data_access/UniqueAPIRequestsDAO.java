package com.orion.logger.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.logger.model.LoggerDatabaseModel;
import com.orion.logger.model.UniqueAPIRequestModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueAPIRequestsDAO extends OrionDAO
{
    public static UniqueAPIRequestModel getByID(String requestID)
    {
        Assert.notEmpty(requestID, "The given requestID is null/empty.");
        UniqueAPIRequestModel model = UniqueAPIRequestModel.of(requestID);
        List<Object> temp = Database.getModels(model,
                        LoggerDatabaseModel.tableUniqueAPIRequests,
                        Database.logsDatabaseName,
                        Arrays.asList(LoggerDatabaseModel.requestID));

        if(temp != null)
        {
            return (UniqueAPIRequestModel)temp.get(0);
        }

        return null;
    }


    public static List<UniqueAPIRequestModel> getByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        UniqueAPIRequestModel model = UniqueAPIRequestModel.ofUserID(userID);
        List<Object> temp = Database.getModels(model,
                        LoggerDatabaseModel.tableUniqueAPIRequests,
                        Database.logsDatabaseName,
                        Arrays.asList(LoggerDatabaseModel.userID));
        List<UniqueAPIRequestModel> results = new ArrayList<>();

        if(temp != null)
        {
            temp.forEach(result -> results.add((UniqueAPIRequestModel)result));
        }

        return results;
    }


    public static int save(UniqueAPIRequestModel model)
    {
        return Database.saveModel(model,
                        LoggerDatabaseModel.tableUniqueAPIRequests,
                        Database.logsDatabaseName);
    }


    public static int update(UniqueAPIRequestModel model)
    {
        return Database.updateModel(model,
                        LoggerDatabaseModel.tableUniqueAPIRequests,
                        Database.logsDatabaseName,
                        Arrays.asList(LoggerDatabaseModel.requestID));
    }


    public static int delete(UniqueAPIRequestModel model)
    {
        Assert.notNull(model, "The given model is null.");
        return Database.deleteModel(model,
                        LoggerDatabaseModel.tableUniqueAPIRequests,
                        Database.logsDatabaseName,
                        Arrays.asList(LoggerDatabaseModel.requestID));
    }
}