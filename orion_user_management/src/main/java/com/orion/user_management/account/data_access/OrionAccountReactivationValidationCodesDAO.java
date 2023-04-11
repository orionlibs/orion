package com.orion.user_management.account.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.user_management.account.model.AccountDatabaseModel;
import com.orion.user_management.account.model.OrionAccountReactivationValidationCodeModel;
import com.orion.user_management.model.UserManagementDatabaseModel;
import java.util.Arrays;

public class OrionAccountReactivationValidationCodesDAO extends OrionDAO
{
    public static long getNumberOfAccountReactivationsYetToBeValidated()
    {
        return Database.getNumberOfRecords(AccountDatabaseModel.tableAccountReactivationValidationCodes,
                        Database.usersDatabaseName);
    }


    public static OrionAccountReactivationValidationCodeModel getByCode(String emailValidationCode)
    {
        Assert.notEmpty(emailValidationCode, "The given emailValidationCode is null/empty.");
        OrionAccountReactivationValidationCodeModel model = OrionAccountReactivationValidationCodeModel.builder()
                        .emailValidationCode(emailValidationCode)
                        .build();
        return (OrionAccountReactivationValidationCodeModel)Database.getOneModel(model,
                        AccountDatabaseModel.tableAccountReactivationValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(AccountDatabaseModel.emailValidationCode));
    }


    public static OrionAccountReactivationValidationCodeModel getByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionAccountReactivationValidationCodeModel model = OrionAccountReactivationValidationCodeModel.builder()
                        .userID(userID)
                        .build();
        return (OrionAccountReactivationValidationCodeModel)Database.getOneModel(model,
                        AccountDatabaseModel.tableAccountReactivationValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static boolean pendingAccountReactivationValidationByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionAccountReactivationValidationCodeModel model = OrionAccountReactivationValidationCodeModel.builder()
                        .userID(userID)
                        .build();
        return Database.doesRowExistWithConditionConjunction(model,
                        AccountDatabaseModel.tableAccountReactivationValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int save(OrionAccountReactivationValidationCodeModel model)
    {
        Assert.notNull(model, "The given OrionAccountReactivationValidationCodeModel is null.");
        return Database.saveModel(model,
                        AccountDatabaseModel.tableAccountReactivationValidationCodes,
                        Database.usersDatabaseName);
    }


    public static int update(OrionAccountReactivationValidationCodeModel model)
    {
        Assert.notNull(model, "The given OrionAccountReactivationValidationCodeModel is null.");
        return Database.updateModel(model,
                        AccountDatabaseModel.tableAccountReactivationValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int delete(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionAccountReactivationValidationCodeModel model = OrionAccountReactivationValidationCodeModel.of(userID);
        return Database.deleteModel(model,
                        AccountDatabaseModel.tableAccountReactivationValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }
}