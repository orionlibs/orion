package com.orion.user_management.authentication.logout.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.user_management.authentication.logout.model.LogoutDatabaseModel;
import com.orion.user_management.authentication.logout.model.OrionUserLogoutCauseModel;
import java.util.Arrays;

public class OrionUserLogoutCausesDAO extends OrionDAO
{
    public static OrionUserLogoutCauseModel getByID(int logoutCauseID)
    {
        OrionUserLogoutCauseModel model = OrionUserLogoutCauseModel.of(logoutCauseID);
        return (OrionUserLogoutCauseModel)Database.getOneModel(model,
                        LogoutDatabaseModel.tableUserLogoutCauses,
                        Database.usersDatabaseName,
                        Arrays.asList(LogoutDatabaseModel.logoutCauseID));
    }


    public static OrionUserLogoutCauseModel getByName(String logoutCause)
    {
        Assert.notEmpty(logoutCause, "The given logoutCause is null/empty.");
        OrionUserLogoutCauseModel model = OrionUserLogoutCauseModel.builder()
                        .logoutCause(logoutCause)
                        .build();
        return (OrionUserLogoutCauseModel)Database.getOneModel(model,
                        LogoutDatabaseModel.tableUserLogoutCauses,
                        Database.usersDatabaseName,
                        Arrays.asList(LogoutDatabaseModel.logoutCause));
    }


    public static int save(OrionUserLogoutCauseModel model)
    {
        return Database.saveModel(model,
                        LogoutDatabaseModel.tableUserLogoutCauses,
                        Database.usersDatabaseName);
    }


    public static int update(OrionUserLogoutCauseModel model)
    {
        return Database.updateModel(model,
                        LogoutDatabaseModel.tableUserLogoutCauses,
                        Database.usersDatabaseName,
                        Arrays.asList(LogoutDatabaseModel.logoutCauseID));
    }
}