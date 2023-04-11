package com.orion.user_management.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.user_management.model.OrionUserSettingsModel;
import com.orion.user_management.model.UserManagementDatabaseModel;
import java.util.Arrays;

public class OrionUserSettingsDAO extends OrionDAO
{
    public static OrionUserSettingsModel getByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserSettingsModel model = OrionUserSettingsModel.of(userID);
        return (OrionUserSettingsModel)Database.getOneModel(model,
                        UserManagementDatabaseModel.tableUserSettings,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static OrionUserSettingsModel getByUserID(OrionUserSettingsModel model)
    {
        Assert.notNull(model, "The given OrionUserSettingsModel is null/empty.");
        return (OrionUserSettingsModel)Database.getOneModel(model,
                        UserManagementDatabaseModel.tableUserSettings,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static String getSelectedThemeByUserID(String userID)
    {
        return getByUserID(userID).getSelectedTheme();
    }


    public static int updateSelectedThemeByUserID(String selectedTheme, String userID)
    {
        Assert.notEmpty(selectedTheme, "The given selectedTheme is null/empty.");
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserSettingsModel model = OrionUserSettingsModel.builder()
                        .userID(userID)
                        .selectedTheme(selectedTheme)
                        .build();
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableUserSettings,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.selectedTheme),
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int save(OrionUserSettingsModel model)
    {
        Assert.notNull(model, "The given OrionUserDetailsModel is null.");
        return Database.saveModel(model,
                        UserManagementDatabaseModel.tableUserSettings,
                        Database.usersDatabaseName);
    }


    public static int update(OrionUserSettingsModel model)
    {
        Assert.notNull(model, "The given OrionUserDetailsModel is null.");
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableUserSettings,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int delete(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserSettingsModel model = OrionUserSettingsModel.of(userID);
        return Database.deleteModel(model,
                        UserManagementDatabaseModel.tableUserSettings,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }
}