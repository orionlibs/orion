package com.orion.user_management.authentication.security.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.user_management.authentication.security.model.FailedLoginDatabaseModel;
import com.orion.user_management.authentication.security.model.OrionUserFailedLoginAttemptModel;
import com.orion.user_management.model.UserManagementDatabaseModel;
import java.util.Arrays;

public class OrionUserFailedLoginAttemptsDAO extends OrionDAO
{
    public static long getNumberOfUsersWithFailedLoginAttempts()
    {
        return Database.getNumberOfRecords(FailedLoginDatabaseModel.tableUserFailedLoginAttempts,
                        Database.usersDatabaseName);
    }


    public static OrionUserFailedLoginAttemptModel getByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserFailedLoginAttemptModel model = OrionUserFailedLoginAttemptModel.of(userID);
        return (OrionUserFailedLoginAttemptModel)Database.getOneModel(model,
                        FailedLoginDatabaseModel.tableUserFailedLoginAttempts,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static OrionUserFailedLoginAttemptModel getByUserIPAddress(String IPAddress)
    {
        Assert.notEmpty(IPAddress, "The given IPAddress is null/empty.");
        OrionUserFailedLoginAttemptModel model = OrionUserFailedLoginAttemptModel.builder()
                        .IPAddress(IPAddress)
                        .build();
        return (OrionUserFailedLoginAttemptModel)Database.getOneModel(model,
                        FailedLoginDatabaseModel.tableUserFailedLoginAttempts,
                        Database.usersDatabaseName,
                        Arrays.asList(FailedLoginDatabaseModel.IPAddress));
    }


    public static int save(OrionUserFailedLoginAttemptModel model)
    {
        return Database.saveModel(model,
                        FailedLoginDatabaseModel.tableUserFailedLoginAttempts,
                        Database.usersDatabaseName);
    }


    public static int update(OrionUserFailedLoginAttemptModel model)
    {
        return Database.updateModel(model,
                        FailedLoginDatabaseModel.tableUserFailedLoginAttempts,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int delete(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserFailedLoginAttemptModel model = OrionUserFailedLoginAttemptModel.builder()
                        .userID(userID)
                        .build();
        return Database.deleteModel(model,
                        FailedLoginDatabaseModel.tableUserFailedLoginAttempts,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }
}