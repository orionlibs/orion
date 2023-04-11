package com.orion.user_management.reset_password.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.user_management.model.UserManagementDatabaseModel;
import com.orion.user_management.reset_password.model.OldPasswordDatabaseModel;
import com.orion.user_management.reset_password.model.OrionUserOldPasswordModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrionUserOldPaswordsDAO extends OrionDAO
{
    public static List<OrionUserOldPasswordModel> getUserOldPasswordsByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserOldPasswordModel model = OrionUserOldPasswordModel.of(userID);
        List<Object> temp = Database.getModels(model,
                        OldPasswordDatabaseModel.tableUserOldPasswords,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
        List<OrionUserOldPasswordModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserOldPasswordModel)model1));
        }

        return results;
    }


    public static int saveUserOldPassword(OrionUserOldPasswordModel model)
    {
        return Database.saveModel(model,
                        OldPasswordDatabaseModel.tableUserOldPasswords,
                        Database.usersDatabaseName);
    }
}